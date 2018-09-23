package net.mindlevel

import slick.jdbc.{JdbcModelBuilder, MySQLProfile}
import slick.jdbc.meta.MTable

import scala.concurrent.ExecutionContext


trait NoSchemaProfile extends MySQLProfile {

  class NoSchemaModelBuilder(mTables: Seq[MTable], ignoreInvalidDefaults: Boolean)(implicit ec: ExecutionContext) extends super.ModelBuilder(mTables, ignoreInvalidDefaults) {

    override def createTableNamer(mTable: MTable): TableNamer = new TableNamer(mTable) {
      override def schema = Option.empty[String]
    }

  }

  override def createModelBuilder(tables: Seq[MTable], ignoreInvalidDefaults: Boolean)(implicit ec: ExecutionContext): JdbcModelBuilder =
    new NoSchemaModelBuilder(tables, ignoreInvalidDefaults)
}