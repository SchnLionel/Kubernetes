import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import java.util.Properties

object BronzeToSilver {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("BronzeToSilver")
      .getOrCreate()

    val url_postgres = "jdbc:postgresql://postgres.sales:5432/sales"
    val props = new Properties()
    props.setProperty("user", "postgres")
    props.setProperty("password", "postgres")
    props.setProperty("driver", "org.postgresql.Driver")

    // Extraction
    val bronzeSales = spark.read.jdbc(url_postgres, "sales", props)
    val bronzeTransactions = spark.read.jdbc(url_postgres, "transaction", props)

    // Transformation
    val silverSales = bronzeSales
      .join(bronzeTransactions, bronzeSales("id") === bronzeTransactions("id_sales"))
      .select(
        bronzeSales("id"),
        bronzeSales("product"),
        bronzeSales("price"),
        bronzeTransactions("quantity"),
        (bronzeSales("price") * bronzeTransactions("quantity")).alias("total_price")
      )

    // Chargement
    silverSales.write
      .mode("overwrite")
      .parquet("/opt/spark/data/silver_sales.parquet")

    spark.stop()
  }
}
