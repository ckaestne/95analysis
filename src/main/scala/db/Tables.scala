package db
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.MySQLProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(`95author`.schema, `95month`.schema, `95timezone`.schema, ___NpmIssueComments.schema, __AllComments.schema, __NpmIssueComments.schema, AuthorsMonthlyCounts.schema, Canonical.schema, CommitComments.schema, CommitParents.schema, Commits.schema, CommitsFiltered.schema, CommitsMonthlyCounts.schema, CommittersMonthlyCounts.schema, Filtered.schema, FilteredWithTravis.schema, Followers.schema, IssueComments.schema, IssueEvents.schema, IssueLabels.schema, Issues.schema, IssuesMonthlyCounts.schema, NpmDepEvents.schema, NpmFiltered.schema, NpmIssueComments.schema, NpmPackages.schema, NpmReleases.schema, NpmSlug2id.schema, NpmToolEvents.schema, NpmTravis.schema, NpmUrls.schema, OrganizationMembers.schema, OrgProjects.schema, ProjectCommits.schema, ProjectLanguages.schema, ProjectMembers.schema, Projects.schema, PrsMonthlyCounts.schema, PullRequestComments.schema, PullRequestCommits.schema, PullRequestHistory.schema, PullRequests.schema, RepoLabels.schema, RepoMilestones.schema, RootsForks.schema, RootsForksS.schema, SchemaInfo.schema, TmpTravisRepos.schema, Users.schema, Watchers.schema, WatchersCount.schema, WatchersMonthlyCounts.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table `95author`
   *  @param repoId Database column repo_id SqlType(INT)
   *  @param authorId Database column author_id SqlType(INT)
   *  @param total95 Database column total95 SqlType(INT), Default(None)
   *  @param totalactivity Database column totalActivity SqlType(INT), Default(None)
   *  @param totalsupport Database column totalSupport SqlType(INT), Default(None) */
  case class `95authorRow`(repoId: Int, authorId: Int, total95: Option[Int] = None, totalactivity: Option[Int] = None, totalsupport: Option[Int] = None)
  /** GetResult implicit for fetching `95authorRow` objects using plain SQL queries */
  implicit def GetResult95authorRow(implicit e0: GR[Int], e1: GR[Option[Int]]): GR[`95authorRow`] = GR{
    prs => import prs._
    `95authorRow`.tupled((<<[Int], <<[Int], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table 95author. Objects of this class serve as prototypes for rows in queries. */
  class `95author`(_tableTag: Tag) extends profile.api.Table[`95authorRow`](_tableTag, Some("ghtorrent"), "95author") {
    def * = (repoId, authorId, total95, totalactivity, totalsupport) <> (`95authorRow`.tupled, `95authorRow`.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(repoId), Rep.Some(authorId), total95, totalactivity, totalsupport).shaped.<>({r=>import r._; _1.map(_=> `95authorRow`.tupled((_1.get, _2.get, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column repo_id SqlType(INT) */
    val repoId: Rep[Int] = column[Int]("repo_id")
    /** Database column author_id SqlType(INT) */
    val authorId: Rep[Int] = column[Int]("author_id")
    /** Database column total95 SqlType(INT), Default(None) */
    val total95: Rep[Option[Int]] = column[Option[Int]]("total95", O.Default(None))
    /** Database column totalActivity SqlType(INT), Default(None) */
    val totalactivity: Rep[Option[Int]] = column[Option[Int]]("totalActivity", O.Default(None))
    /** Database column totalSupport SqlType(INT), Default(None) */
    val totalsupport: Rep[Option[Int]] = column[Option[Int]]("totalSupport", O.Default(None))

    /** Primary key of `95author` (database name 95author_PK) */
    val pk = primaryKey("95author_PK", (repoId, authorId))
  }
  /** Collection-like TableQuery object for table `95author` */
  lazy val `95author` = new TableQuery(tag => new `95author`(tag))

  /** Entity class storing rows of table `95month`
   *  @param authorId Database column author_id SqlType(INT)
   *  @param repoId Database column repo_id SqlType(INT)
   *  @param monthidx Database column monthIdx SqlType(INT)
   *  @param year Database column year SqlType(INT), Default(None)
   *  @param month Database column month SqlType(INT), Default(None)
   *  @param activity Database column activity SqlType(INT), Default(None)
   *  @param activity95 Database column activity95 SqlType(INT), Default(None)
   *  @param activitysupport Database column activitysupport SqlType(INT), Default(None) */
  case class `95monthRow`(authorId: Int, repoId: Int, monthidx: Int, year: Option[Int] = None, month: Option[Int] = None, activity: Option[Int] = None, activity95: Option[Int] = None, activitysupport: Option[Int] = None)
  /** GetResult implicit for fetching `95monthRow` objects using plain SQL queries */
  implicit def GetResult95monthRow(implicit e0: GR[Int], e1: GR[Option[Int]]): GR[`95monthRow`] = GR{
    prs => import prs._
    `95monthRow`.tupled((<<[Int], <<[Int], <<[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table 95month. Objects of this class serve as prototypes for rows in queries. */
  class `95month`(_tableTag: Tag) extends profile.api.Table[`95monthRow`](_tableTag, Some("ghtorrent"), "95month") {
    def * = (authorId, repoId, monthidx, year, month, activity, activity95, activitysupport) <> (`95monthRow`.tupled, `95monthRow`.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(authorId), Rep.Some(repoId), Rep.Some(monthidx), year, month, activity, activity95, activitysupport).shaped.<>({r=>import r._; _1.map(_=> `95monthRow`.tupled((_1.get, _2.get, _3.get, _4, _5, _6, _7, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column author_id SqlType(INT) */
    val authorId: Rep[Int] = column[Int]("author_id")
    /** Database column repo_id SqlType(INT) */
    val repoId: Rep[Int] = column[Int]("repo_id")
    /** Database column monthIdx SqlType(INT) */
    val monthidx: Rep[Int] = column[Int]("monthIdx")
    /** Database column year SqlType(INT), Default(None) */
    val year: Rep[Option[Int]] = column[Option[Int]]("year", O.Default(None))
    /** Database column month SqlType(INT), Default(None) */
    val month: Rep[Option[Int]] = column[Option[Int]]("month", O.Default(None))
    /** Database column activity SqlType(INT), Default(None) */
    val activity: Rep[Option[Int]] = column[Option[Int]]("activity", O.Default(None))
    /** Database column activity95 SqlType(INT), Default(None) */
    val activity95: Rep[Option[Int]] = column[Option[Int]]("activity95", O.Default(None))
    /** Database column activitysupport SqlType(INT), Default(None) */
    val activitysupport: Rep[Option[Int]] = column[Option[Int]]("activitysupport", O.Default(None))

    /** Primary key of `95month` (database name 95month_PK) */
    val pk = primaryKey("95month_PK", (authorId, repoId, monthidx))
  }
  /** Collection-like TableQuery object for table `95month` */
  lazy val `95month` = new TableQuery(tag => new `95month`(tag))

  /** Entity class storing rows of table `95timezone`
   *  @param userId Database column user_id SqlType(INT), PrimaryKey
   *  @param timezone Database column timezone SqlType(INT) */
  case class `95timezoneRow`(userId: Int, timezone: Int)
  /** GetResult implicit for fetching `95timezoneRow` objects using plain SQL queries */
  implicit def GetResult95timezoneRow(implicit e0: GR[Int]): GR[`95timezoneRow`] = GR{
    prs => import prs._
    `95timezoneRow`.tupled((<<[Int], <<[Int]))
  }
  /** Table description of table 95timezone. Objects of this class serve as prototypes for rows in queries. */
  class `95timezone`(_tableTag: Tag) extends profile.api.Table[`95timezoneRow`](_tableTag, Some("ghtorrent"), "95timezone") {
    def * = (userId, timezone) <> (`95timezoneRow`.tupled, `95timezoneRow`.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(userId), Rep.Some(timezone)).shaped.<>({r=>import r._; _1.map(_=> `95timezoneRow`.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column user_id SqlType(INT), PrimaryKey */
    val userId: Rep[Int] = column[Int]("user_id", O.PrimaryKey)
    /** Database column timezone SqlType(INT) */
    val timezone: Rep[Int] = column[Int]("timezone")
  }
  /** Collection-like TableQuery object for table `95timezone` */
  lazy val `95timezone` = new TableQuery(tag => new `95timezone`(tag))

  /** Entity class storing rows of table ___NpmIssueComments
   *  @param id Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey
   *  @param ghtId Database column ght_id SqlType(INT), Default(None)
   *  @param issueNumber Database column issue_number SqlType(INT), Default(None)
   *  @param commentId Database column comment_id SqlType(INT), Default(None)
   *  @param slug Database column slug SqlType(VARCHAR), Length(512,true), Default(None)
   *  @param body Database column body SqlType(TEXT), Default(None)
   *  @param root Database column root SqlType(INT), Default(None) */
  case class ___NpmIssueCommentsRow(id: Long, ghtId: Option[Int] = None, issueNumber: Option[Int] = None, commentId: Option[Int] = None, slug: Option[String] = None, body: Option[String] = None, root: Option[Int] = None)
  /** GetResult implicit for fetching ___NpmIssueCommentsRow objects using plain SQL queries */
  implicit def GetResult___NpmIssueCommentsRow(implicit e0: GR[Long], e1: GR[Option[Int]], e2: GR[Option[String]]): GR[___NpmIssueCommentsRow] = GR{
    prs => import prs._
    ___NpmIssueCommentsRow.tupled((<<[Long], <<?[Int], <<?[Int], <<?[Int], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table ___npm_issue_comments. Objects of this class serve as prototypes for rows in queries. */
  class ___NpmIssueComments(_tableTag: Tag) extends profile.api.Table[___NpmIssueCommentsRow](_tableTag, Some("ghtorrent"), "___npm_issue_comments") {
    def * = (id, ghtId, issueNumber, commentId, slug, body, root) <> (___NpmIssueCommentsRow.tupled, ___NpmIssueCommentsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), ghtId, issueNumber, commentId, slug, body, root).shaped.<>({r=>import r._; _1.map(_=> ___NpmIssueCommentsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column ght_id SqlType(INT), Default(None) */
    val ghtId: Rep[Option[Int]] = column[Option[Int]]("ght_id", O.Default(None))
    /** Database column issue_number SqlType(INT), Default(None) */
    val issueNumber: Rep[Option[Int]] = column[Option[Int]]("issue_number", O.Default(None))
    /** Database column comment_id SqlType(INT), Default(None) */
    val commentId: Rep[Option[Int]] = column[Option[Int]]("comment_id", O.Default(None))
    /** Database column slug SqlType(VARCHAR), Length(512,true), Default(None) */
    val slug: Rep[Option[String]] = column[Option[String]]("slug", O.Length(512,varying=true), O.Default(None))
    /** Database column body SqlType(TEXT), Default(None) */
    val body: Rep[Option[String]] = column[Option[String]]("body", O.Default(None))
    /** Database column root SqlType(INT), Default(None) */
    val root: Rep[Option[Int]] = column[Option[Int]]("root", O.Default(None))

    /** Index over (ghtId) (database name ght_id) */
    val index1 = index("ght_id", ghtId)
    /** Index over (issueNumber) (database name issue_number) */
    val index2 = index("issue_number", issueNumber)
    /** Index over (slug) (database name slug) */
    val index3 = index("slug", slug)
  }
  /** Collection-like TableQuery object for table ___NpmIssueComments */
  lazy val ___NpmIssueComments = new TableQuery(tag => new ___NpmIssueComments(tag))

  /** Entity class storing rows of table __AllComments
   *  @param id Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey
   *  @param ghtId Database column ght_id SqlType(INT), Default(None)
   *  @param issueNumber Database column issue_number SqlType(INT), Default(None)
   *  @param commentId Database column comment_id SqlType(INT), Default(None)
   *  @param slug Database column slug SqlType(VARCHAR), Length(512,true), Default(None)
   *  @param body Database column body SqlType(TEXT), Default(None)
   *  @param root Database column root SqlType(INT), Default(None) */
  case class __AllCommentsRow(id: Long, ghtId: Option[Int] = None, issueNumber: Option[Int] = None, commentId: Option[Int] = None, slug: Option[String] = None, body: Option[String] = None, root: Option[Int] = None)
  /** GetResult implicit for fetching __AllCommentsRow objects using plain SQL queries */
  implicit def GetResult__AllCommentsRow(implicit e0: GR[Long], e1: GR[Option[Int]], e2: GR[Option[String]]): GR[__AllCommentsRow] = GR{
    prs => import prs._
    __AllCommentsRow.tupled((<<[Long], <<?[Int], <<?[Int], <<?[Int], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table __all_comments. Objects of this class serve as prototypes for rows in queries. */
  class __AllComments(_tableTag: Tag) extends profile.api.Table[__AllCommentsRow](_tableTag, Some("ghtorrent"), "__all_comments") {
    def * = (id, ghtId, issueNumber, commentId, slug, body, root) <> (__AllCommentsRow.tupled, __AllCommentsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), ghtId, issueNumber, commentId, slug, body, root).shaped.<>({r=>import r._; _1.map(_=> __AllCommentsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column ght_id SqlType(INT), Default(None) */
    val ghtId: Rep[Option[Int]] = column[Option[Int]]("ght_id", O.Default(None))
    /** Database column issue_number SqlType(INT), Default(None) */
    val issueNumber: Rep[Option[Int]] = column[Option[Int]]("issue_number", O.Default(None))
    /** Database column comment_id SqlType(INT), Default(None) */
    val commentId: Rep[Option[Int]] = column[Option[Int]]("comment_id", O.Default(None))
    /** Database column slug SqlType(VARCHAR), Length(512,true), Default(None) */
    val slug: Rep[Option[String]] = column[Option[String]]("slug", O.Length(512,varying=true), O.Default(None))
    /** Database column body SqlType(TEXT), Default(None) */
    val body: Rep[Option[String]] = column[Option[String]]("body", O.Default(None))
    /** Database column root SqlType(INT), Default(None) */
    val root: Rep[Option[Int]] = column[Option[Int]]("root", O.Default(None))

    /** Index over (ghtId) (database name ght_id) */
    val index1 = index("ght_id", ghtId)
    /** Index over (issueNumber) (database name issue_number) */
    val index2 = index("issue_number", issueNumber)
    /** Index over (slug) (database name slug) */
    val index3 = index("slug", slug)
  }
  /** Collection-like TableQuery object for table __AllComments */
  lazy val __AllComments = new TableQuery(tag => new __AllComments(tag))

  /** Entity class storing rows of table __NpmIssueComments
   *  @param id Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey
   *  @param ghtId Database column ght_id SqlType(INT), Default(None)
   *  @param issueNumber Database column issue_number SqlType(INT), Default(None)
   *  @param commentId Database column comment_id SqlType(INT), Default(None)
   *  @param slug Database column slug SqlType(VARCHAR), Length(512,true), Default(None)
   *  @param body Database column body SqlType(TEXT), Default(None)
   *  @param root Database column root SqlType(INT), Default(None) */
  case class __NpmIssueCommentsRow(id: Long, ghtId: Option[Int] = None, issueNumber: Option[Int] = None, commentId: Option[Int] = None, slug: Option[String] = None, body: Option[String] = None, root: Option[Int] = None)
  /** GetResult implicit for fetching __NpmIssueCommentsRow objects using plain SQL queries */
  implicit def GetResult__NpmIssueCommentsRow(implicit e0: GR[Long], e1: GR[Option[Int]], e2: GR[Option[String]]): GR[__NpmIssueCommentsRow] = GR{
    prs => import prs._
    __NpmIssueCommentsRow.tupled((<<[Long], <<?[Int], <<?[Int], <<?[Int], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table __npm_issue_comments. Objects of this class serve as prototypes for rows in queries. */
  class __NpmIssueComments(_tableTag: Tag) extends profile.api.Table[__NpmIssueCommentsRow](_tableTag, Some("ghtorrent"), "__npm_issue_comments") {
    def * = (id, ghtId, issueNumber, commentId, slug, body, root) <> (__NpmIssueCommentsRow.tupled, __NpmIssueCommentsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), ghtId, issueNumber, commentId, slug, body, root).shaped.<>({r=>import r._; _1.map(_=> __NpmIssueCommentsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column ght_id SqlType(INT), Default(None) */
    val ghtId: Rep[Option[Int]] = column[Option[Int]]("ght_id", O.Default(None))
    /** Database column issue_number SqlType(INT), Default(None) */
    val issueNumber: Rep[Option[Int]] = column[Option[Int]]("issue_number", O.Default(None))
    /** Database column comment_id SqlType(INT), Default(None) */
    val commentId: Rep[Option[Int]] = column[Option[Int]]("comment_id", O.Default(None))
    /** Database column slug SqlType(VARCHAR), Length(512,true), Default(None) */
    val slug: Rep[Option[String]] = column[Option[String]]("slug", O.Length(512,varying=true), O.Default(None))
    /** Database column body SqlType(TEXT), Default(None) */
    val body: Rep[Option[String]] = column[Option[String]]("body", O.Default(None))
    /** Database column root SqlType(INT), Default(None) */
    val root: Rep[Option[Int]] = column[Option[Int]]("root", O.Default(None))

    /** Index over (ghtId) (database name ght_id) */
    val index1 = index("ght_id", ghtId)
    /** Index over (issueNumber) (database name issue_number) */
    val index2 = index("issue_number", issueNumber)
    /** Index over (slug) (database name slug) */
    val index3 = index("slug", slug)
  }
  /** Collection-like TableQuery object for table __NpmIssueComments */
  lazy val __NpmIssueComments = new TableQuery(tag => new __NpmIssueComments(tag))

  /** Entity class storing rows of table AuthorsMonthlyCounts
   *  @param id Database column id SqlType(INT)
   *  @param projectId Database column project_id SqlType(INT), Default(None)
   *  @param authors Database column authors SqlType(INT), Default(None)
   *  @param date Database column date SqlType(TIMESTAMP), Default(None) */
  case class AuthorsMonthlyCountsRow(id: Int, projectId: Option[Int] = None, authors: Option[Int] = None, date: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching AuthorsMonthlyCountsRow objects using plain SQL queries */
  implicit def GetResultAuthorsMonthlyCountsRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[java.sql.Timestamp]]): GR[AuthorsMonthlyCountsRow] = GR{
    prs => import prs._
    AuthorsMonthlyCountsRow.tupled((<<[Int], <<?[Int], <<?[Int], <<?[java.sql.Timestamp]))
  }
  /** Table description of table authors_monthly_counts. Objects of this class serve as prototypes for rows in queries. */
  class AuthorsMonthlyCounts(_tableTag: Tag) extends profile.api.Table[AuthorsMonthlyCountsRow](_tableTag, Some("ghtorrent"), "authors_monthly_counts") {
    def * = (id, projectId, authors, date) <> (AuthorsMonthlyCountsRow.tupled, AuthorsMonthlyCountsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), projectId, authors, date).shaped.<>({r=>import r._; _1.map(_=> AuthorsMonthlyCountsRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT) */
    val id: Rep[Int] = column[Int]("id")
    /** Database column project_id SqlType(INT), Default(None) */
    val projectId: Rep[Option[Int]] = column[Option[Int]]("project_id", O.Default(None))
    /** Database column authors SqlType(INT), Default(None) */
    val authors: Rep[Option[Int]] = column[Option[Int]]("authors", O.Default(None))
    /** Database column date SqlType(TIMESTAMP), Default(None) */
    val date: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("date", O.Default(None))

    /** Index over (date) (database name date) */
    val index1 = index("date", date)
    /** Index over (projectId) (database name project_id) */
    val index2 = index("project_id", projectId)
  }
  /** Collection-like TableQuery object for table AuthorsMonthlyCounts */
  lazy val AuthorsMonthlyCounts = new TableQuery(tag => new AuthorsMonthlyCounts(tag))

  /** Entity class storing rows of table Canonical
   *  @param packagename Database column packagename SqlType(VARCHAR), Length(255,true)
   *  @param repository Database column repository SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param slug Database column slug SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param revisions20170611 Database column revisions_20170611 SqlType(INT), Default(None)
   *  @param readmesize20160917 Database column readmesize_20160917 SqlType(INT), Default(None)
   *  @param targzsize20160917 Database column targzsize_20160917 SqlType(INT), Default(None)
   *  @param downloads201706month Database column downloads201706month SqlType(INT), Default(None) */
  case class CanonicalRow(packagename: String, repository: Option[String] = None, slug: Option[String] = None, revisions20170611: Option[Int] = None, readmesize20160917: Option[Int] = None, targzsize20160917: Option[Int] = None, downloads201706month: Option[Int] = None)
  /** GetResult implicit for fetching CanonicalRow objects using plain SQL queries */
  implicit def GetResultCanonicalRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[CanonicalRow] = GR{
    prs => import prs._
    CanonicalRow.tupled((<<[String], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table canonical. Objects of this class serve as prototypes for rows in queries. */
  class Canonical(_tableTag: Tag) extends profile.api.Table[CanonicalRow](_tableTag, Some("ghtorrent"), "canonical") {
    def * = (packagename, repository, slug, revisions20170611, readmesize20160917, targzsize20160917, downloads201706month) <> (CanonicalRow.tupled, CanonicalRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(packagename), repository, slug, revisions20170611, readmesize20160917, targzsize20160917, downloads201706month).shaped.<>({r=>import r._; _1.map(_=> CanonicalRow.tupled((_1.get, _2, _3, _4, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column packagename SqlType(VARCHAR), Length(255,true) */
    val packagename: Rep[String] = column[String]("packagename", O.Length(255,varying=true))
    /** Database column repository SqlType(VARCHAR), Length(255,true), Default(None) */
    val repository: Rep[Option[String]] = column[Option[String]]("repository", O.Length(255,varying=true), O.Default(None))
    /** Database column slug SqlType(VARCHAR), Length(255,true), Default(None) */
    val slug: Rep[Option[String]] = column[Option[String]]("slug", O.Length(255,varying=true), O.Default(None))
    /** Database column revisions_20170611 SqlType(INT), Default(None) */
    val revisions20170611: Rep[Option[Int]] = column[Option[Int]]("revisions_20170611", O.Default(None))
    /** Database column readmesize_20160917 SqlType(INT), Default(None) */
    val readmesize20160917: Rep[Option[Int]] = column[Option[Int]]("readmesize_20160917", O.Default(None))
    /** Database column targzsize_20160917 SqlType(INT), Default(None) */
    val targzsize20160917: Rep[Option[Int]] = column[Option[Int]]("targzsize_20160917", O.Default(None))
    /** Database column downloads201706month SqlType(INT), Default(None) */
    val downloads201706month: Rep[Option[Int]] = column[Option[Int]]("downloads201706month", O.Default(None))
  }
  /** Collection-like TableQuery object for table Canonical */
  lazy val Canonical = new TableQuery(tag => new Canonical(tag))

  /** Entity class storing rows of table CommitComments
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param commitId Database column commit_id SqlType(INT)
   *  @param userId Database column user_id SqlType(INT)
   *  @param body Database column body SqlType(VARCHAR), Length(256,true), Default(None)
   *  @param line Database column line SqlType(INT), Default(None)
   *  @param position Database column position SqlType(INT), Default(None)
   *  @param commentId Database column comment_id SqlType(INT)
   *  @param createdAt Database column created_at SqlType(TIMESTAMP) */
  case class CommitCommentsRow(id: Int, commitId: Int, userId: Int, body: Option[String] = None, line: Option[Int] = None, position: Option[Int] = None, commentId: Int, createdAt: java.sql.Timestamp)
  /** GetResult implicit for fetching CommitCommentsRow objects using plain SQL queries */
  implicit def GetResultCommitCommentsRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[java.sql.Timestamp]): GR[CommitCommentsRow] = GR{
    prs => import prs._
    CommitCommentsRow.tupled((<<[Int], <<[Int], <<[Int], <<?[String], <<?[Int], <<?[Int], <<[Int], <<[java.sql.Timestamp]))
  }
  /** Table description of table commit_comments. Objects of this class serve as prototypes for rows in queries. */
  class CommitComments(_tableTag: Tag) extends profile.api.Table[CommitCommentsRow](_tableTag, Some("ghtorrent"), "commit_comments") {
    def * = (id, commitId, userId, body, line, position, commentId, createdAt) <> (CommitCommentsRow.tupled, CommitCommentsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(commitId), Rep.Some(userId), body, line, position, Rep.Some(commentId), Rep.Some(createdAt)).shaped.<>({r=>import r._; _1.map(_=> CommitCommentsRow.tupled((_1.get, _2.get, _3.get, _4, _5, _6, _7.get, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column commit_id SqlType(INT) */
    val commitId: Rep[Int] = column[Int]("commit_id")
    /** Database column user_id SqlType(INT) */
    val userId: Rep[Int] = column[Int]("user_id")
    /** Database column body SqlType(VARCHAR), Length(256,true), Default(None) */
    val body: Rep[Option[String]] = column[Option[String]]("body", O.Length(256,varying=true), O.Default(None))
    /** Database column line SqlType(INT), Default(None) */
    val line: Rep[Option[Int]] = column[Option[Int]]("line", O.Default(None))
    /** Database column position SqlType(INT), Default(None) */
    val position: Rep[Option[Int]] = column[Option[Int]]("position", O.Default(None))
    /** Database column comment_id SqlType(INT) */
    val commentId: Rep[Int] = column[Int]("comment_id")
    /** Database column created_at SqlType(TIMESTAMP) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")

    /** Uniqueness Index over (commentId) (database name comment_id) */
    val index1 = index("comment_id", commentId, unique=true)
    /** Index over (commitId) (database name commit_comments_ibfk_1) */
    val index2 = index("commit_comments_ibfk_1", commitId)
    /** Index over (userId) (database name commit_comments_ibfk_2) */
    val index3 = index("commit_comments_ibfk_2", userId)
  }
  /** Collection-like TableQuery object for table CommitComments */
  lazy val CommitComments = new TableQuery(tag => new CommitComments(tag))

  /** Entity class storing rows of table CommitParents
   *  @param commitId Database column commit_id SqlType(INT)
   *  @param parentId Database column parent_id SqlType(INT) */
  case class CommitParentsRow(commitId: Int, parentId: Int)
  /** GetResult implicit for fetching CommitParentsRow objects using plain SQL queries */
  implicit def GetResultCommitParentsRow(implicit e0: GR[Int]): GR[CommitParentsRow] = GR{
    prs => import prs._
    CommitParentsRow.tupled((<<[Int], <<[Int]))
  }
  /** Table description of table commit_parents. Objects of this class serve as prototypes for rows in queries. */
  class CommitParents(_tableTag: Tag) extends profile.api.Table[CommitParentsRow](_tableTag, Some("ghtorrent"), "commit_parents") {
    def * = (commitId, parentId) <> (CommitParentsRow.tupled, CommitParentsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(commitId), Rep.Some(parentId)).shaped.<>({r=>import r._; _1.map(_=> CommitParentsRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column commit_id SqlType(INT) */
    val commitId: Rep[Int] = column[Int]("commit_id")
    /** Database column parent_id SqlType(INT) */
    val parentId: Rep[Int] = column[Int]("parent_id")

    /** Index over (commitId) (database name commit_parents_ibfk_1) */
    val index1 = index("commit_parents_ibfk_1", commitId)
    /** Index over (parentId) (database name commit_parents_ibfk_2) */
    val index2 = index("commit_parents_ibfk_2", parentId)
  }
  /** Collection-like TableQuery object for table CommitParents */
  lazy val CommitParents = new TableQuery(tag => new CommitParents(tag))

  /** Entity class storing rows of table Commits
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param sha Database column sha SqlType(VARCHAR), Length(40,true), Default(None)
   *  @param authorId Database column author_id SqlType(INT), Default(None)
   *  @param committerId Database column committer_id SqlType(INT), Default(None)
   *  @param projectId Database column project_id SqlType(INT), Default(None)
   *  @param createdAt Database column created_at SqlType(TIMESTAMP) */
  case class CommitsRow(id: Int, sha: Option[String] = None, authorId: Option[Int] = None, committerId: Option[Int] = None, projectId: Option[Int] = None, createdAt: java.sql.Timestamp)
  /** GetResult implicit for fetching CommitsRow objects using plain SQL queries */
  implicit def GetResultCommitsRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[java.sql.Timestamp]): GR[CommitsRow] = GR{
    prs => import prs._
    CommitsRow.tupled((<<[Int], <<?[String], <<?[Int], <<?[Int], <<?[Int], <<[java.sql.Timestamp]))
  }
  /** Table description of table commits. Objects of this class serve as prototypes for rows in queries. */
  class Commits(_tableTag: Tag) extends profile.api.Table[CommitsRow](_tableTag, Some("ghtorrent"), "commits") {
    def * = (id, sha, authorId, committerId, projectId, createdAt) <> (CommitsRow.tupled, CommitsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), sha, authorId, committerId, projectId, Rep.Some(createdAt)).shaped.<>({r=>import r._; _1.map(_=> CommitsRow.tupled((_1.get, _2, _3, _4, _5, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column sha SqlType(VARCHAR), Length(40,true), Default(None) */
    val sha: Rep[Option[String]] = column[Option[String]]("sha", O.Length(40,varying=true), O.Default(None))
    /** Database column author_id SqlType(INT), Default(None) */
    val authorId: Rep[Option[Int]] = column[Option[Int]]("author_id", O.Default(None))
    /** Database column committer_id SqlType(INT), Default(None) */
    val committerId: Rep[Option[Int]] = column[Option[Int]]("committer_id", O.Default(None))
    /** Database column project_id SqlType(INT), Default(None) */
    val projectId: Rep[Option[Int]] = column[Option[Int]]("project_id", O.Default(None))
    /** Database column created_at SqlType(TIMESTAMP) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")

    /** Index over (authorId) (database name commits_ibfk_1) */
    val index1 = index("commits_ibfk_1", authorId)
    /** Index over (committerId) (database name commits_ibfk_2) */
    val index2 = index("commits_ibfk_2", committerId)
    /** Index over (projectId) (database name commits_ibfk_3) */
    val index3 = index("commits_ibfk_3", projectId)
    /** Index over (createdAt) (database name created_at) */
    val index4 = index("created_at", createdAt)
    /** Index over (createdAt) (database name created_at_2) */
    val index5 = index("created_at_2", createdAt)
    /** Uniqueness Index over (sha) (database name sha) */
    val index6 = index("sha", sha, unique=true)
  }
  /** Collection-like TableQuery object for table Commits */
  lazy val Commits = new TableQuery(tag => new Commits(tag))

  /** Entity class storing rows of table CommitsFiltered
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param sha Database column sha SqlType(VARCHAR), Length(40,true), Default(None)
   *  @param authorId Database column author_id SqlType(INT), Default(None)
   *  @param committerId Database column committer_id SqlType(INT), Default(None)
   *  @param projectId Database column project_id SqlType(INT), Default(None)
   *  @param createdAt Database column created_at SqlType(TIMESTAMP) */
  case class CommitsFilteredRow(id: Int, sha: Option[String] = None, authorId: Option[Int] = None, committerId: Option[Int] = None, projectId: Option[Int] = None, createdAt: java.sql.Timestamp)
  /** GetResult implicit for fetching CommitsFilteredRow objects using plain SQL queries */
  implicit def GetResultCommitsFilteredRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[java.sql.Timestamp]): GR[CommitsFilteredRow] = GR{
    prs => import prs._
    CommitsFilteredRow.tupled((<<[Int], <<?[String], <<?[Int], <<?[Int], <<?[Int], <<[java.sql.Timestamp]))
  }
  /** Table description of table commits_filtered. Objects of this class serve as prototypes for rows in queries. */
  class CommitsFiltered(_tableTag: Tag) extends profile.api.Table[CommitsFilteredRow](_tableTag, Some("ghtorrent"), "commits_filtered") {
    def * = (id, sha, authorId, committerId, projectId, createdAt) <> (CommitsFilteredRow.tupled, CommitsFilteredRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), sha, authorId, committerId, projectId, Rep.Some(createdAt)).shaped.<>({r=>import r._; _1.map(_=> CommitsFilteredRow.tupled((_1.get, _2, _3, _4, _5, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column sha SqlType(VARCHAR), Length(40,true), Default(None) */
    val sha: Rep[Option[String]] = column[Option[String]]("sha", O.Length(40,varying=true), O.Default(None))
    /** Database column author_id SqlType(INT), Default(None) */
    val authorId: Rep[Option[Int]] = column[Option[Int]]("author_id", O.Default(None))
    /** Database column committer_id SqlType(INT), Default(None) */
    val committerId: Rep[Option[Int]] = column[Option[Int]]("committer_id", O.Default(None))
    /** Database column project_id SqlType(INT), Default(None) */
    val projectId: Rep[Option[Int]] = column[Option[Int]]("project_id", O.Default(None))
    /** Database column created_at SqlType(TIMESTAMP) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")

    /** Index over (authorId) (database name commits_ibfk_1) */
    val index1 = index("commits_ibfk_1", authorId)
    /** Index over (committerId) (database name commits_ibfk_2) */
    val index2 = index("commits_ibfk_2", committerId)
    /** Index over (projectId) (database name commits_ibfk_3) */
    val index3 = index("commits_ibfk_3", projectId)
    /** Index over (createdAt) (database name created_at) */
    val index4 = index("created_at", createdAt)
    /** Index over (createdAt) (database name created_at_2) */
    val index5 = index("created_at_2", createdAt)
    /** Uniqueness Index over (sha) (database name sha) */
    val index6 = index("sha", sha, unique=true)
  }
  /** Collection-like TableQuery object for table CommitsFiltered */
  lazy val CommitsFiltered = new TableQuery(tag => new CommitsFiltered(tag))

  /** Entity class storing rows of table CommitsMonthlyCounts
   *  @param id Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey
   *  @param projectId Database column project_id SqlType(INT), Default(None)
   *  @param commits Database column commits SqlType(INT), Default(None)
   *  @param date Database column date SqlType(TIMESTAMP), Default(None) */
  case class CommitsMonthlyCountsRow(id: Long, projectId: Option[Int] = None, commits: Option[Int] = None, date: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching CommitsMonthlyCountsRow objects using plain SQL queries */
  implicit def GetResultCommitsMonthlyCountsRow(implicit e0: GR[Long], e1: GR[Option[Int]], e2: GR[Option[java.sql.Timestamp]]): GR[CommitsMonthlyCountsRow] = GR{
    prs => import prs._
    CommitsMonthlyCountsRow.tupled((<<[Long], <<?[Int], <<?[Int], <<?[java.sql.Timestamp]))
  }
  /** Table description of table commits_monthly_counts. Objects of this class serve as prototypes for rows in queries. */
  class CommitsMonthlyCounts(_tableTag: Tag) extends profile.api.Table[CommitsMonthlyCountsRow](_tableTag, Some("ghtorrent"), "commits_monthly_counts") {
    def * = (id, projectId, commits, date) <> (CommitsMonthlyCountsRow.tupled, CommitsMonthlyCountsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), projectId, commits, date).shaped.<>({r=>import r._; _1.map(_=> CommitsMonthlyCountsRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column project_id SqlType(INT), Default(None) */
    val projectId: Rep[Option[Int]] = column[Option[Int]]("project_id", O.Default(None))
    /** Database column commits SqlType(INT), Default(None) */
    val commits: Rep[Option[Int]] = column[Option[Int]]("commits", O.Default(None))
    /** Database column date SqlType(TIMESTAMP), Default(None) */
    val date: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("date", O.Default(None))

    /** Index over (date) (database name date) */
    val index1 = index("date", date)
    /** Index over (projectId) (database name project_id) */
    val index2 = index("project_id", projectId)
  }
  /** Collection-like TableQuery object for table CommitsMonthlyCounts */
  lazy val CommitsMonthlyCounts = new TableQuery(tag => new CommitsMonthlyCounts(tag))

  /** Entity class storing rows of table CommittersMonthlyCounts
   *  @param id Database column id SqlType(INT)
   *  @param projectId Database column project_id SqlType(INT), Default(None)
   *  @param committers Database column committers SqlType(INT), Default(None)
   *  @param date Database column date SqlType(TIMESTAMP), Default(None) */
  case class CommittersMonthlyCountsRow(id: Int, projectId: Option[Int] = None, committers: Option[Int] = None, date: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching CommittersMonthlyCountsRow objects using plain SQL queries */
  implicit def GetResultCommittersMonthlyCountsRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[java.sql.Timestamp]]): GR[CommittersMonthlyCountsRow] = GR{
    prs => import prs._
    CommittersMonthlyCountsRow.tupled((<<[Int], <<?[Int], <<?[Int], <<?[java.sql.Timestamp]))
  }
  /** Table description of table committers_monthly_counts. Objects of this class serve as prototypes for rows in queries. */
  class CommittersMonthlyCounts(_tableTag: Tag) extends profile.api.Table[CommittersMonthlyCountsRow](_tableTag, Some("ghtorrent"), "committers_monthly_counts") {
    def * = (id, projectId, committers, date) <> (CommittersMonthlyCountsRow.tupled, CommittersMonthlyCountsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), projectId, committers, date).shaped.<>({r=>import r._; _1.map(_=> CommittersMonthlyCountsRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT) */
    val id: Rep[Int] = column[Int]("id")
    /** Database column project_id SqlType(INT), Default(None) */
    val projectId: Rep[Option[Int]] = column[Option[Int]]("project_id", O.Default(None))
    /** Database column committers SqlType(INT), Default(None) */
    val committers: Rep[Option[Int]] = column[Option[Int]]("committers", O.Default(None))
    /** Database column date SqlType(TIMESTAMP), Default(None) */
    val date: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("date", O.Default(None))

    /** Index over (date) (database name date) */
    val index1 = index("date", date)
    /** Index over (projectId) (database name project_id) */
    val index2 = index("project_id", projectId)
  }
  /** Collection-like TableQuery object for table CommittersMonthlyCounts */
  lazy val CommittersMonthlyCounts = new TableQuery(tag => new CommittersMonthlyCounts(tag))

  /** Entity class storing rows of table Filtered
   *  @param lastCommitDate Database column last_commit_date SqlType(TIMESTAMP), Default(None)
   *  @param firstCommitDate Database column first_commit_date SqlType(TIMESTAMP), Default(None)
   *  @param years Database column years SqlType(DECIMAL), Default(None)
   *  @param packagename Database column packagename SqlType(VARCHAR), Length(255,true)
   *  @param repository Database column repository SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param slug Database column slug SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param revisions20170611 Database column revisions_20170611 SqlType(INT), Default(None)
   *  @param readmesize20160917 Database column readmesize_20160917 SqlType(INT), Default(None)
   *  @param targzsize20160917 Database column targzsize_20160917 SqlType(INT), Default(None)
   *  @param downloads201706month Database column downloads201706month SqlType(INT), Default(None) */
  case class FilteredRow(lastCommitDate: Option[java.sql.Timestamp] = None, firstCommitDate: Option[java.sql.Timestamp] = None, years: Option[scala.math.BigDecimal] = None, packagename: String, repository: Option[String] = None, slug: Option[String] = None, revisions20170611: Option[Int] = None, readmesize20160917: Option[Int] = None, targzsize20160917: Option[Int] = None, downloads201706month: Option[Int] = None)
  /** GetResult implicit for fetching FilteredRow objects using plain SQL queries */
  implicit def GetResultFilteredRow(implicit e0: GR[Option[java.sql.Timestamp]], e1: GR[Option[scala.math.BigDecimal]], e2: GR[String], e3: GR[Option[String]], e4: GR[Option[Int]]): GR[FilteredRow] = GR{
    prs => import prs._
    FilteredRow.tupled((<<?[java.sql.Timestamp], <<?[java.sql.Timestamp], <<?[scala.math.BigDecimal], <<[String], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table filtered. Objects of this class serve as prototypes for rows in queries. */
  class Filtered(_tableTag: Tag) extends profile.api.Table[FilteredRow](_tableTag, Some("ghtorrent"), "filtered") {
    def * = (lastCommitDate, firstCommitDate, years, packagename, repository, slug, revisions20170611, readmesize20160917, targzsize20160917, downloads201706month) <> (FilteredRow.tupled, FilteredRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (lastCommitDate, firstCommitDate, years, Rep.Some(packagename), repository, slug, revisions20170611, readmesize20160917, targzsize20160917, downloads201706month).shaped.<>({r=>import r._; _4.map(_=> FilteredRow.tupled((_1, _2, _3, _4.get, _5, _6, _7, _8, _9, _10)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column last_commit_date SqlType(TIMESTAMP), Default(None) */
    val lastCommitDate: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("last_commit_date", O.Default(None))
    /** Database column first_commit_date SqlType(TIMESTAMP), Default(None) */
    val firstCommitDate: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("first_commit_date", O.Default(None))
    /** Database column years SqlType(DECIMAL), Default(None) */
    val years: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("years", O.Default(None))
    /** Database column packagename SqlType(VARCHAR), Length(255,true) */
    val packagename: Rep[String] = column[String]("packagename", O.Length(255,varying=true))
    /** Database column repository SqlType(VARCHAR), Length(255,true), Default(None) */
    val repository: Rep[Option[String]] = column[Option[String]]("repository", O.Length(255,varying=true), O.Default(None))
    /** Database column slug SqlType(VARCHAR), Length(255,true), Default(None) */
    val slug: Rep[Option[String]] = column[Option[String]]("slug", O.Length(255,varying=true), O.Default(None))
    /** Database column revisions_20170611 SqlType(INT), Default(None) */
    val revisions20170611: Rep[Option[Int]] = column[Option[Int]]("revisions_20170611", O.Default(None))
    /** Database column readmesize_20160917 SqlType(INT), Default(None) */
    val readmesize20160917: Rep[Option[Int]] = column[Option[Int]]("readmesize_20160917", O.Default(None))
    /** Database column targzsize_20160917 SqlType(INT), Default(None) */
    val targzsize20160917: Rep[Option[Int]] = column[Option[Int]]("targzsize_20160917", O.Default(None))
    /** Database column downloads201706month SqlType(INT), Default(None) */
    val downloads201706month: Rep[Option[Int]] = column[Option[Int]]("downloads201706month", O.Default(None))
  }
  /** Collection-like TableQuery object for table Filtered */
  lazy val Filtered = new TableQuery(tag => new Filtered(tag))

  /** Entity class storing rows of table FilteredWithTravis
   *  @param lastCommitDate Database column last_commit_date SqlType(TIMESTAMP), Default(None)
   *  @param firstCommitDate Database column first_commit_date SqlType(TIMESTAMP), Default(None)
   *  @param years Database column years SqlType(DECIMAL), Default(None)
   *  @param packagename Database column packagename SqlType(VARCHAR), Length(255,true)
   *  @param repository Database column repository SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param slug Database column slug SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param revisions20170611 Database column revisions_20170611 SqlType(INT), Default(None)
   *  @param readmesize20160917 Database column readmesize_20160917 SqlType(INT), Default(None)
   *  @param targzsize20160917 Database column targzsize_20160917 SqlType(INT), Default(None)
   *  @param downloads201706month Database column downloads201706month SqlType(INT), Default(None) */
  case class FilteredWithTravisRow(lastCommitDate: Option[java.sql.Timestamp] = None, firstCommitDate: Option[java.sql.Timestamp] = None, years: Option[scala.math.BigDecimal] = None, packagename: String, repository: Option[String] = None, slug: Option[String] = None, revisions20170611: Option[Int] = None, readmesize20160917: Option[Int] = None, targzsize20160917: Option[Int] = None, downloads201706month: Option[Int] = None)
  /** GetResult implicit for fetching FilteredWithTravisRow objects using plain SQL queries */
  implicit def GetResultFilteredWithTravisRow(implicit e0: GR[Option[java.sql.Timestamp]], e1: GR[Option[scala.math.BigDecimal]], e2: GR[String], e3: GR[Option[String]], e4: GR[Option[Int]]): GR[FilteredWithTravisRow] = GR{
    prs => import prs._
    FilteredWithTravisRow.tupled((<<?[java.sql.Timestamp], <<?[java.sql.Timestamp], <<?[scala.math.BigDecimal], <<[String], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table filtered_with_travis. Objects of this class serve as prototypes for rows in queries. */
  class FilteredWithTravis(_tableTag: Tag) extends profile.api.Table[FilteredWithTravisRow](_tableTag, Some("ghtorrent"), "filtered_with_travis") {
    def * = (lastCommitDate, firstCommitDate, years, packagename, repository, slug, revisions20170611, readmesize20160917, targzsize20160917, downloads201706month) <> (FilteredWithTravisRow.tupled, FilteredWithTravisRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (lastCommitDate, firstCommitDate, years, Rep.Some(packagename), repository, slug, revisions20170611, readmesize20160917, targzsize20160917, downloads201706month).shaped.<>({r=>import r._; _4.map(_=> FilteredWithTravisRow.tupled((_1, _2, _3, _4.get, _5, _6, _7, _8, _9, _10)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column last_commit_date SqlType(TIMESTAMP), Default(None) */
    val lastCommitDate: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("last_commit_date", O.Default(None))
    /** Database column first_commit_date SqlType(TIMESTAMP), Default(None) */
    val firstCommitDate: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("first_commit_date", O.Default(None))
    /** Database column years SqlType(DECIMAL), Default(None) */
    val years: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("years", O.Default(None))
    /** Database column packagename SqlType(VARCHAR), Length(255,true) */
    val packagename: Rep[String] = column[String]("packagename", O.Length(255,varying=true))
    /** Database column repository SqlType(VARCHAR), Length(255,true), Default(None) */
    val repository: Rep[Option[String]] = column[Option[String]]("repository", O.Length(255,varying=true), O.Default(None))
    /** Database column slug SqlType(VARCHAR), Length(255,true), Default(None) */
    val slug: Rep[Option[String]] = column[Option[String]]("slug", O.Length(255,varying=true), O.Default(None))
    /** Database column revisions_20170611 SqlType(INT), Default(None) */
    val revisions20170611: Rep[Option[Int]] = column[Option[Int]]("revisions_20170611", O.Default(None))
    /** Database column readmesize_20160917 SqlType(INT), Default(None) */
    val readmesize20160917: Rep[Option[Int]] = column[Option[Int]]("readmesize_20160917", O.Default(None))
    /** Database column targzsize_20160917 SqlType(INT), Default(None) */
    val targzsize20160917: Rep[Option[Int]] = column[Option[Int]]("targzsize_20160917", O.Default(None))
    /** Database column downloads201706month SqlType(INT), Default(None) */
    val downloads201706month: Rep[Option[Int]] = column[Option[Int]]("downloads201706month", O.Default(None))
  }
  /** Collection-like TableQuery object for table FilteredWithTravis */
  lazy val FilteredWithTravis = new TableQuery(tag => new FilteredWithTravis(tag))

  /** Entity class storing rows of table Followers
   *  @param followerId Database column follower_id SqlType(INT)
   *  @param userId Database column user_id SqlType(INT)
   *  @param createdAt Database column created_at SqlType(TIMESTAMP) */
  case class FollowersRow(followerId: Int, userId: Int, createdAt: java.sql.Timestamp)
  /** GetResult implicit for fetching FollowersRow objects using plain SQL queries */
  implicit def GetResultFollowersRow(implicit e0: GR[Int], e1: GR[java.sql.Timestamp]): GR[FollowersRow] = GR{
    prs => import prs._
    FollowersRow.tupled((<<[Int], <<[Int], <<[java.sql.Timestamp]))
  }
  /** Table description of table followers. Objects of this class serve as prototypes for rows in queries. */
  class Followers(_tableTag: Tag) extends profile.api.Table[FollowersRow](_tableTag, Some("ghtorrent"), "followers") {
    def * = (followerId, userId, createdAt) <> (FollowersRow.tupled, FollowersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(followerId), Rep.Some(userId), Rep.Some(createdAt)).shaped.<>({r=>import r._; _1.map(_=> FollowersRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column follower_id SqlType(INT) */
    val followerId: Rep[Int] = column[Int]("follower_id")
    /** Database column user_id SqlType(INT) */
    val userId: Rep[Int] = column[Int]("user_id")
    /** Database column created_at SqlType(TIMESTAMP) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")

    /** Primary key of Followers (database name followers_PK) */
    val pk = primaryKey("followers_PK", (followerId, userId))

    /** Index over (userId) (database name follower_fk2) */
    val index1 = index("follower_fk2", userId)
    /** Index over (followerId) (database name follower_id) */
    val index2 = index("follower_id", followerId)
  }
  /** Collection-like TableQuery object for table Followers */
  lazy val Followers = new TableQuery(tag => new Followers(tag))

  /** Entity class storing rows of table IssueComments
   *  @param issueId Database column issue_id SqlType(INT)
   *  @param userId Database column user_id SqlType(INT)
   *  @param commentId Database column comment_id SqlType(MEDIUMTEXT), Length(16777215,true)
   *  @param createdAt Database column created_at SqlType(TIMESTAMP) */
  case class IssueCommentsRow(issueId: Int, userId: Int, commentId: String, createdAt: java.sql.Timestamp)
  /** GetResult implicit for fetching IssueCommentsRow objects using plain SQL queries */
  implicit def GetResultIssueCommentsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[IssueCommentsRow] = GR{
    prs => import prs._
    IssueCommentsRow.tupled((<<[Int], <<[Int], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table issue_comments. Objects of this class serve as prototypes for rows in queries. */
  class IssueComments(_tableTag: Tag) extends profile.api.Table[IssueCommentsRow](_tableTag, Some("ghtorrent"), "issue_comments") {
    def * = (issueId, userId, commentId, createdAt) <> (IssueCommentsRow.tupled, IssueCommentsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(issueId), Rep.Some(userId), Rep.Some(commentId), Rep.Some(createdAt)).shaped.<>({r=>import r._; _1.map(_=> IssueCommentsRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column issue_id SqlType(INT) */
    val issueId: Rep[Int] = column[Int]("issue_id")
    /** Database column user_id SqlType(INT) */
    val userId: Rep[Int] = column[Int]("user_id")
    /** Database column comment_id SqlType(MEDIUMTEXT), Length(16777215,true) */
    val commentId: Rep[String] = column[String]("comment_id", O.Length(16777215,varying=true))
    /** Database column created_at SqlType(TIMESTAMP) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")

    /** Index over (issueId) (database name issue_comments_ibfk_1) */
    val index1 = index("issue_comments_ibfk_1", issueId)
    /** Index over (userId) (database name issue_comments_ibfk_2) */
    val index2 = index("issue_comments_ibfk_2", userId)
  }
  /** Collection-like TableQuery object for table IssueComments */
  lazy val IssueComments = new TableQuery(tag => new IssueComments(tag))

  /** Entity class storing rows of table IssueEvents
   *  @param eventId Database column event_id SqlType(MEDIUMTEXT), Length(16777215,true)
   *  @param issueId Database column issue_id SqlType(INT)
   *  @param actorId Database column actor_id SqlType(INT)
   *  @param action Database column action SqlType(VARCHAR), Length(255,true)
   *  @param actionSpecific Database column action_specific SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param createdAt Database column created_at SqlType(TIMESTAMP) */
  case class IssueEventsRow(eventId: String, issueId: Int, actorId: Int, action: String, actionSpecific: Option[String] = None, createdAt: java.sql.Timestamp)
  /** GetResult implicit for fetching IssueEventsRow objects using plain SQL queries */
  implicit def GetResultIssueEventsRow(implicit e0: GR[String], e1: GR[Int], e2: GR[Option[String]], e3: GR[java.sql.Timestamp]): GR[IssueEventsRow] = GR{
    prs => import prs._
    IssueEventsRow.tupled((<<[String], <<[Int], <<[Int], <<[String], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table issue_events. Objects of this class serve as prototypes for rows in queries. */
  class IssueEvents(_tableTag: Tag) extends profile.api.Table[IssueEventsRow](_tableTag, Some("ghtorrent"), "issue_events") {
    def * = (eventId, issueId, actorId, action, actionSpecific, createdAt) <> (IssueEventsRow.tupled, IssueEventsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(eventId), Rep.Some(issueId), Rep.Some(actorId), Rep.Some(action), actionSpecific, Rep.Some(createdAt)).shaped.<>({r=>import r._; _1.map(_=> IssueEventsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column event_id SqlType(MEDIUMTEXT), Length(16777215,true) */
    val eventId: Rep[String] = column[String]("event_id", O.Length(16777215,varying=true))
    /** Database column issue_id SqlType(INT) */
    val issueId: Rep[Int] = column[Int]("issue_id")
    /** Database column actor_id SqlType(INT) */
    val actorId: Rep[Int] = column[Int]("actor_id")
    /** Database column action SqlType(VARCHAR), Length(255,true) */
    val action: Rep[String] = column[String]("action", O.Length(255,varying=true))
    /** Database column action_specific SqlType(VARCHAR), Length(50,true), Default(None) */
    val actionSpecific: Rep[Option[String]] = column[Option[String]]("action_specific", O.Length(50,varying=true), O.Default(None))
    /** Database column created_at SqlType(TIMESTAMP) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")

    /** Index over (issueId) (database name issue_events_ibfk_1) */
    val index1 = index("issue_events_ibfk_1", issueId)
    /** Index over (actorId) (database name issue_events_ibfk_2) */
    val index2 = index("issue_events_ibfk_2", actorId)
  }
  /** Collection-like TableQuery object for table IssueEvents */
  lazy val IssueEvents = new TableQuery(tag => new IssueEvents(tag))

  /** Entity class storing rows of table IssueLabels
   *  @param labelId Database column label_id SqlType(INT)
   *  @param issueId Database column issue_id SqlType(INT) */
  case class IssueLabelsRow(labelId: Int, issueId: Int)
  /** GetResult implicit for fetching IssueLabelsRow objects using plain SQL queries */
  implicit def GetResultIssueLabelsRow(implicit e0: GR[Int]): GR[IssueLabelsRow] = GR{
    prs => import prs._
    IssueLabelsRow.tupled((<<[Int], <<[Int]))
  }
  /** Table description of table issue_labels. Objects of this class serve as prototypes for rows in queries. */
  class IssueLabels(_tableTag: Tag) extends profile.api.Table[IssueLabelsRow](_tableTag, Some("ghtorrent"), "issue_labels") {
    def * = (labelId, issueId) <> (IssueLabelsRow.tupled, IssueLabelsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(labelId), Rep.Some(issueId)).shaped.<>({r=>import r._; _1.map(_=> IssueLabelsRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column label_id SqlType(INT) */
    val labelId: Rep[Int] = column[Int]("label_id")
    /** Database column issue_id SqlType(INT) */
    val issueId: Rep[Int] = column[Int]("issue_id")

    /** Primary key of IssueLabels (database name issue_labels_PK) */
    val pk = primaryKey("issue_labels_PK", (issueId, labelId))

    /** Index over (labelId) (database name issue_labels_ibfk_1) */
    val index1 = index("issue_labels_ibfk_1", labelId)
  }
  /** Collection-like TableQuery object for table IssueLabels */
  lazy val IssueLabels = new TableQuery(tag => new IssueLabels(tag))

  /** Entity class storing rows of table Issues
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param repoId Database column repo_id SqlType(INT), Default(None)
   *  @param reporterId Database column reporter_id SqlType(INT), Default(None)
   *  @param assigneeId Database column assignee_id SqlType(INT), Default(None)
   *  @param pullRequest Database column pull_request SqlType(BIT)
   *  @param pullRequestId Database column pull_request_id SqlType(INT), Default(None)
   *  @param createdAt Database column created_at SqlType(TIMESTAMP)
   *  @param issueId Database column issue_id SqlType(INT) */
  case class IssuesRow(id: Int, repoId: Option[Int] = None, reporterId: Option[Int] = None, assigneeId: Option[Int] = None, pullRequest: Boolean, pullRequestId: Option[Int] = None, createdAt: java.sql.Timestamp, issueId: Int)
  /** GetResult implicit for fetching IssuesRow objects using plain SQL queries */
  implicit def GetResultIssuesRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Boolean], e3: GR[java.sql.Timestamp]): GR[IssuesRow] = GR{
    prs => import prs._
    IssuesRow.tupled((<<[Int], <<?[Int], <<?[Int], <<?[Int], <<[Boolean], <<?[Int], <<[java.sql.Timestamp], <<[Int]))
  }
  /** Table description of table issues. Objects of this class serve as prototypes for rows in queries. */
  class Issues(_tableTag: Tag) extends profile.api.Table[IssuesRow](_tableTag, Some("ghtorrent"), "issues") {
    def * = (id, repoId, reporterId, assigneeId, pullRequest, pullRequestId, createdAt, issueId) <> (IssuesRow.tupled, IssuesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), repoId, reporterId, assigneeId, Rep.Some(pullRequest), pullRequestId, Rep.Some(createdAt), Rep.Some(issueId)).shaped.<>({r=>import r._; _1.map(_=> IssuesRow.tupled((_1.get, _2, _3, _4, _5.get, _6, _7.get, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column repo_id SqlType(INT), Default(None) */
    val repoId: Rep[Option[Int]] = column[Option[Int]]("repo_id", O.Default(None))
    /** Database column reporter_id SqlType(INT), Default(None) */
    val reporterId: Rep[Option[Int]] = column[Option[Int]]("reporter_id", O.Default(None))
    /** Database column assignee_id SqlType(INT), Default(None) */
    val assigneeId: Rep[Option[Int]] = column[Option[Int]]("assignee_id", O.Default(None))
    /** Database column pull_request SqlType(BIT) */
    val pullRequest: Rep[Boolean] = column[Boolean]("pull_request")
    /** Database column pull_request_id SqlType(INT), Default(None) */
    val pullRequestId: Rep[Option[Int]] = column[Option[Int]]("pull_request_id", O.Default(None))
    /** Database column created_at SqlType(TIMESTAMP) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column issue_id SqlType(INT) */
    val issueId: Rep[Int] = column[Int]("issue_id")

    /** Index over (repoId) (database name issues_ibfk_1) */
    val index1 = index("issues_ibfk_1", repoId)
    /** Index over (reporterId) (database name issues_ibfk_2) */
    val index2 = index("issues_ibfk_2", reporterId)
    /** Index over (assigneeId) (database name issues_ibfk_3) */
    val index3 = index("issues_ibfk_3", assigneeId)
    /** Index over (pullRequestId) (database name issues_ibfk_4) */
    val index4 = index("issues_ibfk_4", pullRequestId)
  }
  /** Collection-like TableQuery object for table Issues */
  lazy val Issues = new TableQuery(tag => new Issues(tag))

  /** Entity class storing rows of table IssuesMonthlyCounts
   *  @param id Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey
   *  @param projectId Database column project_id SqlType(INT), Default(None)
   *  @param issues Database column issues SqlType(INT), Default(None)
   *  @param date Database column date SqlType(TIMESTAMP), Default(None) */
  case class IssuesMonthlyCountsRow(id: Long, projectId: Option[Int] = None, issues: Option[Int] = None, date: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching IssuesMonthlyCountsRow objects using plain SQL queries */
  implicit def GetResultIssuesMonthlyCountsRow(implicit e0: GR[Long], e1: GR[Option[Int]], e2: GR[Option[java.sql.Timestamp]]): GR[IssuesMonthlyCountsRow] = GR{
    prs => import prs._
    IssuesMonthlyCountsRow.tupled((<<[Long], <<?[Int], <<?[Int], <<?[java.sql.Timestamp]))
  }
  /** Table description of table issues_monthly_counts. Objects of this class serve as prototypes for rows in queries. */
  class IssuesMonthlyCounts(_tableTag: Tag) extends profile.api.Table[IssuesMonthlyCountsRow](_tableTag, Some("ghtorrent"), "issues_monthly_counts") {
    def * = (id, projectId, issues, date) <> (IssuesMonthlyCountsRow.tupled, IssuesMonthlyCountsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), projectId, issues, date).shaped.<>({r=>import r._; _1.map(_=> IssuesMonthlyCountsRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column project_id SqlType(INT), Default(None) */
    val projectId: Rep[Option[Int]] = column[Option[Int]]("project_id", O.Default(None))
    /** Database column issues SqlType(INT), Default(None) */
    val issues: Rep[Option[Int]] = column[Option[Int]]("issues", O.Default(None))
    /** Database column date SqlType(TIMESTAMP), Default(None) */
    val date: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("date", O.Default(None))

    /** Index over (date) (database name date) */
    val index1 = index("date", date)
    /** Index over (projectId) (database name project_id) */
    val index2 = index("project_id", projectId)
  }
  /** Collection-like TableQuery object for table IssuesMonthlyCounts */
  lazy val IssuesMonthlyCounts = new TableQuery(tag => new IssuesMonthlyCounts(tag))

  /** Entity class storing rows of table NpmDepEvents
   *  @param id Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey
   *  @param packagename Database column packagename SqlType(VARCHAR), Length(128,true), Default(None)
   *  @param `type` Database column type SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param content Database column content SqlType(TEXT), Default(None)
   *  @param time Database column time SqlType(TIMESTAMP), Default(None)
   *  @param commit Database column commit SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param num Database column num SqlType(INT), Default(None) */
  case class NpmDepEventsRow(id: Long, packagename: Option[String] = None, `type`: Option[String] = None, content: Option[String] = None, time: Option[java.sql.Timestamp] = None, commit: Option[String] = None, num: Option[Int] = None)
  /** GetResult implicit for fetching NpmDepEventsRow objects using plain SQL queries */
  implicit def GetResultNpmDepEventsRow(implicit e0: GR[Long], e1: GR[Option[String]], e2: GR[Option[java.sql.Timestamp]], e3: GR[Option[Int]]): GR[NpmDepEventsRow] = GR{
    prs => import prs._
    NpmDepEventsRow.tupled((<<[Long], <<?[String], <<?[String], <<?[String], <<?[java.sql.Timestamp], <<?[String], <<?[Int]))
  }
  /** Table description of table npm_dep_events. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class NpmDepEvents(_tableTag: Tag) extends profile.api.Table[NpmDepEventsRow](_tableTag, Some("ghtorrent"), "npm_dep_events") {
    def * = (id, packagename, `type`, content, time, commit, num) <> (NpmDepEventsRow.tupled, NpmDepEventsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), packagename, `type`, content, time, commit, num).shaped.<>({r=>import r._; _1.map(_=> NpmDepEventsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column packagename SqlType(VARCHAR), Length(128,true), Default(None) */
    val packagename: Rep[Option[String]] = column[Option[String]]("packagename", O.Length(128,varying=true), O.Default(None))
    /** Database column type SqlType(VARCHAR), Length(32,true), Default(None)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Option[String]] = column[Option[String]]("type", O.Length(32,varying=true), O.Default(None))
    /** Database column content SqlType(TEXT), Default(None) */
    val content: Rep[Option[String]] = column[Option[String]]("content", O.Default(None))
    /** Database column time SqlType(TIMESTAMP), Default(None) */
    val time: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("time", O.Default(None))
    /** Database column commit SqlType(VARCHAR), Length(32,true), Default(None) */
    val commit: Rep[Option[String]] = column[Option[String]]("commit", O.Length(32,varying=true), O.Default(None))
    /** Database column num SqlType(INT), Default(None) */
    val num: Rep[Option[Int]] = column[Option[Int]]("num", O.Default(None))
  }
  /** Collection-like TableQuery object for table NpmDepEvents */
  lazy val NpmDepEvents = new TableQuery(tag => new NpmDepEvents(tag))

  /** Entity class storing rows of table NpmFiltered
   *  @param lastCommitDate Database column last_commit_date SqlType(TIMESTAMP), Default(None)
   *  @param firstCommitDate Database column first_commit_date SqlType(TIMESTAMP), Default(None)
   *  @param years Database column years SqlType(DECIMAL), Default(None)
   *  @param packagename Database column packagename SqlType(VARCHAR), Length(255,true)
   *  @param repository Database column repository SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param slug Database column slug SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param revisions20170611 Database column revisions_20170611 SqlType(INT), Default(None)
   *  @param readmesize20160917 Database column readmesize_20160917 SqlType(INT), Default(None)
   *  @param targzsize20160917 Database column targzsize_20160917 SqlType(INT), Default(None)
   *  @param downloads201706month Database column downloads201706month SqlType(INT), Default(None) */
  case class NpmFilteredRow(lastCommitDate: Option[java.sql.Timestamp] = None, firstCommitDate: Option[java.sql.Timestamp] = None, years: Option[scala.math.BigDecimal] = None, packagename: String, repository: Option[String] = None, slug: Option[String] = None, revisions20170611: Option[Int] = None, readmesize20160917: Option[Int] = None, targzsize20160917: Option[Int] = None, downloads201706month: Option[Int] = None)
  /** GetResult implicit for fetching NpmFilteredRow objects using plain SQL queries */
  implicit def GetResultNpmFilteredRow(implicit e0: GR[Option[java.sql.Timestamp]], e1: GR[Option[scala.math.BigDecimal]], e2: GR[String], e3: GR[Option[String]], e4: GR[Option[Int]]): GR[NpmFilteredRow] = GR{
    prs => import prs._
    NpmFilteredRow.tupled((<<?[java.sql.Timestamp], <<?[java.sql.Timestamp], <<?[scala.math.BigDecimal], <<[String], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table npm_filtered. Objects of this class serve as prototypes for rows in queries. */
  class NpmFiltered(_tableTag: Tag) extends profile.api.Table[NpmFilteredRow](_tableTag, Some("ghtorrent"), "npm_filtered") {
    def * = (lastCommitDate, firstCommitDate, years, packagename, repository, slug, revisions20170611, readmesize20160917, targzsize20160917, downloads201706month) <> (NpmFilteredRow.tupled, NpmFilteredRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (lastCommitDate, firstCommitDate, years, Rep.Some(packagename), repository, slug, revisions20170611, readmesize20160917, targzsize20160917, downloads201706month).shaped.<>({r=>import r._; _4.map(_=> NpmFilteredRow.tupled((_1, _2, _3, _4.get, _5, _6, _7, _8, _9, _10)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column last_commit_date SqlType(TIMESTAMP), Default(None) */
    val lastCommitDate: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("last_commit_date", O.Default(None))
    /** Database column first_commit_date SqlType(TIMESTAMP), Default(None) */
    val firstCommitDate: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("first_commit_date", O.Default(None))
    /** Database column years SqlType(DECIMAL), Default(None) */
    val years: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("years", O.Default(None))
    /** Database column packagename SqlType(VARCHAR), Length(255,true) */
    val packagename: Rep[String] = column[String]("packagename", O.Length(255,varying=true))
    /** Database column repository SqlType(VARCHAR), Length(255,true), Default(None) */
    val repository: Rep[Option[String]] = column[Option[String]]("repository", O.Length(255,varying=true), O.Default(None))
    /** Database column slug SqlType(VARCHAR), Length(255,true), Default(None) */
    val slug: Rep[Option[String]] = column[Option[String]]("slug", O.Length(255,varying=true), O.Default(None))
    /** Database column revisions_20170611 SqlType(INT), Default(None) */
    val revisions20170611: Rep[Option[Int]] = column[Option[Int]]("revisions_20170611", O.Default(None))
    /** Database column readmesize_20160917 SqlType(INT), Default(None) */
    val readmesize20160917: Rep[Option[Int]] = column[Option[Int]]("readmesize_20160917", O.Default(None))
    /** Database column targzsize_20160917 SqlType(INT), Default(None) */
    val targzsize20160917: Rep[Option[Int]] = column[Option[Int]]("targzsize_20160917", O.Default(None))
    /** Database column downloads201706month SqlType(INT), Default(None) */
    val downloads201706month: Rep[Option[Int]] = column[Option[Int]]("downloads201706month", O.Default(None))
  }
  /** Collection-like TableQuery object for table NpmFiltered */
  lazy val NpmFiltered = new TableQuery(tag => new NpmFiltered(tag))

  /** Entity class storing rows of table NpmIssueComments
   *  @param id Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey
   *  @param ghtId Database column ght_id SqlType(INT), Default(None)
   *  @param issueNumber Database column issue_number SqlType(INT), Default(None)
   *  @param commentId Database column comment_id SqlType(INT), Default(None)
   *  @param slug Database column slug SqlType(VARCHAR), Length(512,true), Default(None)
   *  @param body Database column body SqlType(TEXT), Default(None)
   *  @param root Database column root SqlType(INT), Default(None) */
  case class NpmIssueCommentsRow(id: Long, ghtId: Option[Int] = None, issueNumber: Option[Int] = None, commentId: Option[Int] = None, slug: Option[String] = None, body: Option[String] = None, root: Option[Int] = None)
  /** GetResult implicit for fetching NpmIssueCommentsRow objects using plain SQL queries */
  implicit def GetResultNpmIssueCommentsRow(implicit e0: GR[Long], e1: GR[Option[Int]], e2: GR[Option[String]]): GR[NpmIssueCommentsRow] = GR{
    prs => import prs._
    NpmIssueCommentsRow.tupled((<<[Long], <<?[Int], <<?[Int], <<?[Int], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table npm_issue_comments. Objects of this class serve as prototypes for rows in queries. */
  class NpmIssueComments(_tableTag: Tag) extends profile.api.Table[NpmIssueCommentsRow](_tableTag, Some("ghtorrent"), "npm_issue_comments") {
    def * = (id, ghtId, issueNumber, commentId, slug, body, root) <> (NpmIssueCommentsRow.tupled, NpmIssueCommentsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), ghtId, issueNumber, commentId, slug, body, root).shaped.<>({r=>import r._; _1.map(_=> NpmIssueCommentsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column ght_id SqlType(INT), Default(None) */
    val ghtId: Rep[Option[Int]] = column[Option[Int]]("ght_id", O.Default(None))
    /** Database column issue_number SqlType(INT), Default(None) */
    val issueNumber: Rep[Option[Int]] = column[Option[Int]]("issue_number", O.Default(None))
    /** Database column comment_id SqlType(INT), Default(None) */
    val commentId: Rep[Option[Int]] = column[Option[Int]]("comment_id", O.Default(None))
    /** Database column slug SqlType(VARCHAR), Length(512,true), Default(None) */
    val slug: Rep[Option[String]] = column[Option[String]]("slug", O.Length(512,varying=true), O.Default(None))
    /** Database column body SqlType(TEXT), Default(None) */
    val body: Rep[Option[String]] = column[Option[String]]("body", O.Default(None))
    /** Database column root SqlType(INT), Default(None) */
    val root: Rep[Option[Int]] = column[Option[Int]]("root", O.Default(None))

    /** Index over (ghtId) (database name ght_id) */
    val index1 = index("ght_id", ghtId)
    /** Index over (issueNumber) (database name issue_number) */
    val index2 = index("issue_number", issueNumber)
    /** Index over (slug) (database name slug) */
    val index3 = index("slug", slug)
  }
  /** Collection-like TableQuery object for table NpmIssueComments */
  lazy val NpmIssueComments = new TableQuery(tag => new NpmIssueComments(tag))

  /** Entity class storing rows of table NpmPackages
   *  @param packagename Database column packagename SqlType(VARCHAR), PrimaryKey, Length(255,true)
   *  @param repository Database column repository SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param slug Database column slug SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param revisions20170611 Database column revisions_20170611 SqlType(INT), Default(None)
   *  @param readmesize20160917 Database column readmesize_20160917 SqlType(INT), Default(None)
   *  @param targzsize20160917 Database column targzsize_20160917 SqlType(INT), Default(None)
   *  @param downloads201706month Database column downloads201706month SqlType(INT), Default(None) */
  case class NpmPackagesRow(packagename: String, repository: Option[String] = None, slug: Option[String] = None, revisions20170611: Option[Int] = None, readmesize20160917: Option[Int] = None, targzsize20160917: Option[Int] = None, downloads201706month: Option[Int] = None)
  /** GetResult implicit for fetching NpmPackagesRow objects using plain SQL queries */
  implicit def GetResultNpmPackagesRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[NpmPackagesRow] = GR{
    prs => import prs._
    NpmPackagesRow.tupled((<<[String], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table npm_packages. Objects of this class serve as prototypes for rows in queries. */
  class NpmPackages(_tableTag: Tag) extends profile.api.Table[NpmPackagesRow](_tableTag, Some("ghtorrent"), "npm_packages") {
    def * = (packagename, repository, slug, revisions20170611, readmesize20160917, targzsize20160917, downloads201706month) <> (NpmPackagesRow.tupled, NpmPackagesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(packagename), repository, slug, revisions20170611, readmesize20160917, targzsize20160917, downloads201706month).shaped.<>({r=>import r._; _1.map(_=> NpmPackagesRow.tupled((_1.get, _2, _3, _4, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column packagename SqlType(VARCHAR), PrimaryKey, Length(255,true) */
    val packagename: Rep[String] = column[String]("packagename", O.PrimaryKey, O.Length(255,varying=true))
    /** Database column repository SqlType(VARCHAR), Length(255,true), Default(None) */
    val repository: Rep[Option[String]] = column[Option[String]]("repository", O.Length(255,varying=true), O.Default(None))
    /** Database column slug SqlType(VARCHAR), Length(255,true), Default(None) */
    val slug: Rep[Option[String]] = column[Option[String]]("slug", O.Length(255,varying=true), O.Default(None))
    /** Database column revisions_20170611 SqlType(INT), Default(None) */
    val revisions20170611: Rep[Option[Int]] = column[Option[Int]]("revisions_20170611", O.Default(None))
    /** Database column readmesize_20160917 SqlType(INT), Default(None) */
    val readmesize20160917: Rep[Option[Int]] = column[Option[Int]]("readmesize_20160917", O.Default(None))
    /** Database column targzsize_20160917 SqlType(INT), Default(None) */
    val targzsize20160917: Rep[Option[Int]] = column[Option[Int]]("targzsize_20160917", O.Default(None))
    /** Database column downloads201706month SqlType(INT), Default(None) */
    val downloads201706month: Rep[Option[Int]] = column[Option[Int]]("downloads201706month", O.Default(None))

    /** Index over (slug) (database name slug_UNIQUE) */
    val index1 = index("slug_UNIQUE", slug)
  }
  /** Collection-like TableQuery object for table NpmPackages */
  lazy val NpmPackages = new TableQuery(tag => new NpmPackages(tag))

  /** Entity class storing rows of table NpmReleases
   *  @param id Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey
   *  @param packagename Database column packagename SqlType(VARCHAR), Length(512,true), Default(None)
   *  @param release Database column release SqlType(VARCHAR), Length(64,true), Default(None)
   *  @param time Database column time SqlType(TIMESTAMP), Default(None) */
  case class NpmReleasesRow(id: Long, packagename: Option[String] = None, release: Option[String] = None, time: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching NpmReleasesRow objects using plain SQL queries */
  implicit def GetResultNpmReleasesRow(implicit e0: GR[Long], e1: GR[Option[String]], e2: GR[Option[java.sql.Timestamp]]): GR[NpmReleasesRow] = GR{
    prs => import prs._
    NpmReleasesRow.tupled((<<[Long], <<?[String], <<?[String], <<?[java.sql.Timestamp]))
  }
  /** Table description of table npm_releases. Objects of this class serve as prototypes for rows in queries. */
  class NpmReleases(_tableTag: Tag) extends profile.api.Table[NpmReleasesRow](_tableTag, Some("ghtorrent"), "npm_releases") {
    def * = (id, packagename, release, time) <> (NpmReleasesRow.tupled, NpmReleasesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), packagename, release, time).shaped.<>({r=>import r._; _1.map(_=> NpmReleasesRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column packagename SqlType(VARCHAR), Length(512,true), Default(None) */
    val packagename: Rep[Option[String]] = column[Option[String]]("packagename", O.Length(512,varying=true), O.Default(None))
    /** Database column release SqlType(VARCHAR), Length(64,true), Default(None) */
    val release: Rep[Option[String]] = column[Option[String]]("release", O.Length(64,varying=true), O.Default(None))
    /** Database column time SqlType(TIMESTAMP), Default(None) */
    val time: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("time", O.Default(None))
  }
  /** Collection-like TableQuery object for table NpmReleases */
  lazy val NpmReleases = new TableQuery(tag => new NpmReleases(tag))

  /** Entity class storing rows of table NpmSlug2id
   *  @param id Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey
   *  @param ghtId Database column ght_id SqlType(INT), Default(None)
   *  @param slug Database column slug SqlType(VARCHAR), Length(512,true), Default(None)
   *  @param downloads Database column downloads SqlType(INT), Default(None) */
  case class NpmSlug2idRow(id: Long, ghtId: Option[Int] = None, slug: Option[String] = None, downloads: Option[Int] = None)
  /** GetResult implicit for fetching NpmSlug2idRow objects using plain SQL queries */
  implicit def GetResultNpmSlug2idRow(implicit e0: GR[Long], e1: GR[Option[Int]], e2: GR[Option[String]]): GR[NpmSlug2idRow] = GR{
    prs => import prs._
    NpmSlug2idRow.tupled((<<[Long], <<?[Int], <<?[String], <<?[Int]))
  }
  /** Table description of table npm_slug2id. Objects of this class serve as prototypes for rows in queries. */
  class NpmSlug2id(_tableTag: Tag) extends profile.api.Table[NpmSlug2idRow](_tableTag, Some("ghtorrent"), "npm_slug2id") {
    def * = (id, ghtId, slug, downloads) <> (NpmSlug2idRow.tupled, NpmSlug2idRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), ghtId, slug, downloads).shaped.<>({r=>import r._; _1.map(_=> NpmSlug2idRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column ght_id SqlType(INT), Default(None) */
    val ghtId: Rep[Option[Int]] = column[Option[Int]]("ght_id", O.Default(None))
    /** Database column slug SqlType(VARCHAR), Length(512,true), Default(None) */
    val slug: Rep[Option[String]] = column[Option[String]]("slug", O.Length(512,varying=true), O.Default(None))
    /** Database column downloads SqlType(INT), Default(None) */
    val downloads: Rep[Option[Int]] = column[Option[Int]]("downloads", O.Default(None))

    /** Index over (ghtId) (database name ght_id) */
    val index1 = index("ght_id", ghtId)
    /** Index over (slug) (database name slug) */
    val index2 = index("slug", slug)
  }
  /** Collection-like TableQuery object for table NpmSlug2id */
  lazy val NpmSlug2id = new TableQuery(tag => new NpmSlug2id(tag))

  /** Entity class storing rows of table NpmToolEvents
   *  @param id Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey
   *  @param packagename Database column packagename SqlType(VARCHAR), Length(128,true), Default(None)
   *  @param `type` Database column type SqlType(VARCHAR), Length(16,true), Default(None)
   *  @param tool Database column tool SqlType(VARCHAR), Length(64,true), Default(None)
   *  @param time Database column time SqlType(TIMESTAMP), Default(None) */
  case class NpmToolEventsRow(id: Long, packagename: Option[String] = None, `type`: Option[String] = None, tool: Option[String] = None, time: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching NpmToolEventsRow objects using plain SQL queries */
  implicit def GetResultNpmToolEventsRow(implicit e0: GR[Long], e1: GR[Option[String]], e2: GR[Option[java.sql.Timestamp]]): GR[NpmToolEventsRow] = GR{
    prs => import prs._
    NpmToolEventsRow.tupled((<<[Long], <<?[String], <<?[String], <<?[String], <<?[java.sql.Timestamp]))
  }
  /** Table description of table npm_tool_events. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class NpmToolEvents(_tableTag: Tag) extends profile.api.Table[NpmToolEventsRow](_tableTag, Some("ghtorrent"), "npm_tool_events") {
    def * = (id, packagename, `type`, tool, time) <> (NpmToolEventsRow.tupled, NpmToolEventsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), packagename, `type`, tool, time).shaped.<>({r=>import r._; _1.map(_=> NpmToolEventsRow.tupled((_1.get, _2, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column packagename SqlType(VARCHAR), Length(128,true), Default(None) */
    val packagename: Rep[Option[String]] = column[Option[String]]("packagename", O.Length(128,varying=true), O.Default(None))
    /** Database column type SqlType(VARCHAR), Length(16,true), Default(None)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Option[String]] = column[Option[String]]("type", O.Length(16,varying=true), O.Default(None))
    /** Database column tool SqlType(VARCHAR), Length(64,true), Default(None) */
    val tool: Rep[Option[String]] = column[Option[String]]("tool", O.Length(64,varying=true), O.Default(None))
    /** Database column time SqlType(TIMESTAMP), Default(None) */
    val time: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("time", O.Default(None))
  }
  /** Collection-like TableQuery object for table NpmToolEvents */
  lazy val NpmToolEvents = new TableQuery(tag => new NpmToolEvents(tag))

  /** Entity class storing rows of table NpmTravis
   *  @param id Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey
   *  @param slug Database column slug SqlType(VARCHAR), Length(512,true), Default(None)
   *  @param packagename Database column packagename SqlType(VARCHAR), Length(256,true), Default(None)
   *  @param downloads Database column downloads SqlType(INT), Default(None)
   *  @param releases Database column releases SqlType(INT), Default(None)
   *  @param issues Database column issues SqlType(INT), Default(None)
   *  @param commits Database column commits SqlType(INT), Default(None) */
  case class NpmTravisRow(id: Long, slug: Option[String] = None, packagename: Option[String] = None, downloads: Option[Int] = None, releases: Option[Int] = None, issues: Option[Int] = None, commits: Option[Int] = None)
  /** GetResult implicit for fetching NpmTravisRow objects using plain SQL queries */
  implicit def GetResultNpmTravisRow(implicit e0: GR[Long], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[NpmTravisRow] = GR{
    prs => import prs._
    NpmTravisRow.tupled((<<[Long], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table npm_travis. Objects of this class serve as prototypes for rows in queries. */
  class NpmTravis(_tableTag: Tag) extends profile.api.Table[NpmTravisRow](_tableTag, Some("ghtorrent"), "npm_travis") {
    def * = (id, slug, packagename, downloads, releases, issues, commits) <> (NpmTravisRow.tupled, NpmTravisRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), slug, packagename, downloads, releases, issues, commits).shaped.<>({r=>import r._; _1.map(_=> NpmTravisRow.tupled((_1.get, _2, _3, _4, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column slug SqlType(VARCHAR), Length(512,true), Default(None) */
    val slug: Rep[Option[String]] = column[Option[String]]("slug", O.Length(512,varying=true), O.Default(None))
    /** Database column packagename SqlType(VARCHAR), Length(256,true), Default(None) */
    val packagename: Rep[Option[String]] = column[Option[String]]("packagename", O.Length(256,varying=true), O.Default(None))
    /** Database column downloads SqlType(INT), Default(None) */
    val downloads: Rep[Option[Int]] = column[Option[Int]]("downloads", O.Default(None))
    /** Database column releases SqlType(INT), Default(None) */
    val releases: Rep[Option[Int]] = column[Option[Int]]("releases", O.Default(None))
    /** Database column issues SqlType(INT), Default(None) */
    val issues: Rep[Option[Int]] = column[Option[Int]]("issues", O.Default(None))
    /** Database column commits SqlType(INT), Default(None) */
    val commits: Rep[Option[Int]] = column[Option[Int]]("commits", O.Default(None))
  }
  /** Collection-like TableQuery object for table NpmTravis */
  lazy val NpmTravis = new TableQuery(tag => new NpmTravis(tag))

  /** Entity class storing rows of table NpmUrls
   *  @param id Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey
   *  @param tld Database column tld SqlType(VARCHAR), Length(512,true), Default(None)
   *  @param packagename Database column packagename SqlType(VARCHAR), Length(512,true), Default(None) */
  case class NpmUrlsRow(id: Long, tld: Option[String] = None, packagename: Option[String] = None)
  /** GetResult implicit for fetching NpmUrlsRow objects using plain SQL queries */
  implicit def GetResultNpmUrlsRow(implicit e0: GR[Long], e1: GR[Option[String]]): GR[NpmUrlsRow] = GR{
    prs => import prs._
    NpmUrlsRow.tupled((<<[Long], <<?[String], <<?[String]))
  }
  /** Table description of table npm_urls. Objects of this class serve as prototypes for rows in queries. */
  class NpmUrls(_tableTag: Tag) extends profile.api.Table[NpmUrlsRow](_tableTag, Some("ghtorrent"), "npm_urls") {
    def * = (id, tld, packagename) <> (NpmUrlsRow.tupled, NpmUrlsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), tld, packagename).shaped.<>({r=>import r._; _1.map(_=> NpmUrlsRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column tld SqlType(VARCHAR), Length(512,true), Default(None) */
    val tld: Rep[Option[String]] = column[Option[String]]("tld", O.Length(512,varying=true), O.Default(None))
    /** Database column packagename SqlType(VARCHAR), Length(512,true), Default(None) */
    val packagename: Rep[Option[String]] = column[Option[String]]("packagename", O.Length(512,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table NpmUrls */
  lazy val NpmUrls = new TableQuery(tag => new NpmUrls(tag))

  /** Entity class storing rows of table OrganizationMembers
   *  @param orgId Database column org_id SqlType(INT)
   *  @param userId Database column user_id SqlType(INT)
   *  @param createdAt Database column created_at SqlType(TIMESTAMP) */
  case class OrganizationMembersRow(orgId: Int, userId: Int, createdAt: java.sql.Timestamp)
  /** GetResult implicit for fetching OrganizationMembersRow objects using plain SQL queries */
  implicit def GetResultOrganizationMembersRow(implicit e0: GR[Int], e1: GR[java.sql.Timestamp]): GR[OrganizationMembersRow] = GR{
    prs => import prs._
    OrganizationMembersRow.tupled((<<[Int], <<[Int], <<[java.sql.Timestamp]))
  }
  /** Table description of table organization_members. Objects of this class serve as prototypes for rows in queries. */
  class OrganizationMembers(_tableTag: Tag) extends profile.api.Table[OrganizationMembersRow](_tableTag, Some("ghtorrent"), "organization_members") {
    def * = (orgId, userId, createdAt) <> (OrganizationMembersRow.tupled, OrganizationMembersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(orgId), Rep.Some(userId), Rep.Some(createdAt)).shaped.<>({r=>import r._; _1.map(_=> OrganizationMembersRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column org_id SqlType(INT) */
    val orgId: Rep[Int] = column[Int]("org_id")
    /** Database column user_id SqlType(INT) */
    val userId: Rep[Int] = column[Int]("user_id")
    /** Database column created_at SqlType(TIMESTAMP) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")

    /** Primary key of OrganizationMembers (database name organization_members_PK) */
    val pk = primaryKey("organization_members_PK", (orgId, userId))

    /** Index over (userId) (database name organization_members_ibfk_2) */
    val index1 = index("organization_members_ibfk_2", userId)
  }
  /** Collection-like TableQuery object for table OrganizationMembers */
  lazy val OrganizationMembers = new TableQuery(tag => new OrganizationMembers(tag))

  /** Entity class storing rows of table OrgProjects
   *  @param login Database column login SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param url Database column url SqlType(VARCHAR), Length(255,true), Default(None) */
  case class OrgProjectsRow(login: Option[String] = None, url: Option[String] = None)
  /** GetResult implicit for fetching OrgProjectsRow objects using plain SQL queries */
  implicit def GetResultOrgProjectsRow(implicit e0: GR[Option[String]]): GR[OrgProjectsRow] = GR{
    prs => import prs._
    OrgProjectsRow.tupled((<<?[String], <<?[String]))
  }
  /** Table description of table org_projects. Objects of this class serve as prototypes for rows in queries. */
  class OrgProjects(_tableTag: Tag) extends profile.api.Table[OrgProjectsRow](_tableTag, Some("ghtorrent"), "org_projects") {
    def * = (login, url) <> (OrgProjectsRow.tupled, OrgProjectsRow.unapply)

    /** Database column login SqlType(VARCHAR), Length(255,true), Default(None) */
    val login: Rep[Option[String]] = column[Option[String]]("login", O.Length(255,varying=true), O.Default(None))
    /** Database column url SqlType(VARCHAR), Length(255,true), Default(None) */
    val url: Rep[Option[String]] = column[Option[String]]("url", O.Length(255,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table OrgProjects */
  lazy val OrgProjects = new TableQuery(tag => new OrgProjects(tag))

  /** Entity class storing rows of table ProjectCommits
   *  @param projectId Database column project_id SqlType(INT), Default(0)
   *  @param commitId Database column commit_id SqlType(INT), Default(0) */
  case class ProjectCommitsRow(projectId: Int = 0, commitId: Int = 0)
  /** GetResult implicit for fetching ProjectCommitsRow objects using plain SQL queries */
  implicit def GetResultProjectCommitsRow(implicit e0: GR[Int]): GR[ProjectCommitsRow] = GR{
    prs => import prs._
    ProjectCommitsRow.tupled((<<[Int], <<[Int]))
  }
  /** Table description of table project_commits. Objects of this class serve as prototypes for rows in queries. */
  class ProjectCommits(_tableTag: Tag) extends profile.api.Table[ProjectCommitsRow](_tableTag, Some("ghtorrent"), "project_commits") {
    def * = (projectId, commitId) <> (ProjectCommitsRow.tupled, ProjectCommitsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(projectId), Rep.Some(commitId)).shaped.<>({r=>import r._; _1.map(_=> ProjectCommitsRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column project_id SqlType(INT), Default(0) */
    val projectId: Rep[Int] = column[Int]("project_id", O.Default(0))
    /** Database column commit_id SqlType(INT), Default(0) */
    val commitId: Rep[Int] = column[Int]("commit_id", O.Default(0))

    /** Index over (commitId) (database name commit_id) */
    val index1 = index("commit_id", commitId)
    /** Index over (projectId) (database name project_commits_ibfk_1) */
    val index2 = index("project_commits_ibfk_1", projectId)
  }
  /** Collection-like TableQuery object for table ProjectCommits */
  lazy val ProjectCommits = new TableQuery(tag => new ProjectCommits(tag))

  /** Entity class storing rows of table ProjectLanguages
   *  @param projectId Database column project_id SqlType(INT)
   *  @param language Database column language SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param bytes Database column bytes SqlType(INT), Default(None)
   *  @param createdAt Database column created_at SqlType(TIMESTAMP) */
  case class ProjectLanguagesRow(projectId: Int, language: Option[String] = None, bytes: Option[Int] = None, createdAt: java.sql.Timestamp)
  /** GetResult implicit for fetching ProjectLanguagesRow objects using plain SQL queries */
  implicit def GetResultProjectLanguagesRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[java.sql.Timestamp]): GR[ProjectLanguagesRow] = GR{
    prs => import prs._
    ProjectLanguagesRow.tupled((<<[Int], <<?[String], <<?[Int], <<[java.sql.Timestamp]))
  }
  /** Table description of table project_languages. Objects of this class serve as prototypes for rows in queries. */
  class ProjectLanguages(_tableTag: Tag) extends profile.api.Table[ProjectLanguagesRow](_tableTag, Some("ghtorrent"), "project_languages") {
    def * = (projectId, language, bytes, createdAt) <> (ProjectLanguagesRow.tupled, ProjectLanguagesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(projectId), language, bytes, Rep.Some(createdAt)).shaped.<>({r=>import r._; _1.map(_=> ProjectLanguagesRow.tupled((_1.get, _2, _3, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column project_id SqlType(INT) */
    val projectId: Rep[Int] = column[Int]("project_id")
    /** Database column language SqlType(VARCHAR), Length(255,true), Default(None) */
    val language: Rep[Option[String]] = column[Option[String]]("language", O.Length(255,varying=true), O.Default(None))
    /** Database column bytes SqlType(INT), Default(None) */
    val bytes: Rep[Option[Int]] = column[Option[Int]]("bytes", O.Default(None))
    /** Database column created_at SqlType(TIMESTAMP) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")

    /** Index over (projectId) (database name project_id) */
    val index1 = index("project_id", projectId)
  }
  /** Collection-like TableQuery object for table ProjectLanguages */
  lazy val ProjectLanguages = new TableQuery(tag => new ProjectLanguages(tag))

  /** Entity class storing rows of table ProjectMembers
   *  @param repoId Database column repo_id SqlType(INT)
   *  @param userId Database column user_id SqlType(INT)
   *  @param createdAt Database column created_at SqlType(TIMESTAMP)
   *  @param extRefId Database column ext_ref_id SqlType(VARCHAR), Length(24,true), Default(0) */
  case class ProjectMembersRow(repoId: Int, userId: Int, createdAt: java.sql.Timestamp, extRefId: String = "0")
  /** GetResult implicit for fetching ProjectMembersRow objects using plain SQL queries */
  implicit def GetResultProjectMembersRow(implicit e0: GR[Int], e1: GR[java.sql.Timestamp], e2: GR[String]): GR[ProjectMembersRow] = GR{
    prs => import prs._
    ProjectMembersRow.tupled((<<[Int], <<[Int], <<[java.sql.Timestamp], <<[String]))
  }
  /** Table description of table project_members. Objects of this class serve as prototypes for rows in queries. */
  class ProjectMembers(_tableTag: Tag) extends profile.api.Table[ProjectMembersRow](_tableTag, Some("ghtorrent"), "project_members") {
    def * = (repoId, userId, createdAt, extRefId) <> (ProjectMembersRow.tupled, ProjectMembersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(repoId), Rep.Some(userId), Rep.Some(createdAt), Rep.Some(extRefId)).shaped.<>({r=>import r._; _1.map(_=> ProjectMembersRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column repo_id SqlType(INT) */
    val repoId: Rep[Int] = column[Int]("repo_id")
    /** Database column user_id SqlType(INT) */
    val userId: Rep[Int] = column[Int]("user_id")
    /** Database column created_at SqlType(TIMESTAMP) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column ext_ref_id SqlType(VARCHAR), Length(24,true), Default(0) */
    val extRefId: Rep[String] = column[String]("ext_ref_id", O.Length(24,varying=true), O.Default("0"))

    /** Primary key of ProjectMembers (database name project_members_PK) */
    val pk = primaryKey("project_members_PK", (repoId, userId))

    /** Index over (userId) (database name project_members_ibfk_2) */
    val index1 = index("project_members_ibfk_2", userId)
  }
  /** Collection-like TableQuery object for table ProjectMembers */
  lazy val ProjectMembers = new TableQuery(tag => new ProjectMembers(tag))

  /** Entity class storing rows of table Projects
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param url Database column url SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param ownerId Database column owner_id SqlType(INT), Default(None)
   *  @param name Database column name SqlType(VARCHAR), Length(255,true)
   *  @param description Database column description SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param language Database column language SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param createdAt Database column created_at SqlType(TIMESTAMP)
   *  @param forkedFrom Database column forked_from SqlType(INT), Default(None)
   *  @param deleted Database column deleted SqlType(BIT), Default(false)
   *  @param updatedAt Database column updated_at SqlType(TIMESTAMP)
   *  @param slug Database column slug SqlType(INT), Default(None) */
  case class ProjectsRow(id: Int, url: Option[String] = None, ownerId: Option[Int] = None, name: String, description: Option[String] = None, language: Option[String] = None, createdAt: java.sql.Timestamp, forkedFrom: Option[Int] = None, deleted: Boolean = false, updatedAt: java.sql.Timestamp, slug: Option[Int] = None)
  /** GetResult implicit for fetching ProjectsRow objects using plain SQL queries */
  implicit def GetResultProjectsRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[String], e4: GR[java.sql.Timestamp], e5: GR[Boolean]): GR[ProjectsRow] = GR{
    prs => import prs._
    ProjectsRow.tupled((<<[Int], <<?[String], <<?[Int], <<[String], <<?[String], <<?[String], <<[java.sql.Timestamp], <<?[Int], <<[Boolean], <<[java.sql.Timestamp], <<?[Int]))
  }
  /** Table description of table projects. Objects of this class serve as prototypes for rows in queries. */
  class Projects(_tableTag: Tag) extends profile.api.Table[ProjectsRow](_tableTag, Some("ghtorrent"), "projects") {
    def * = (id, url, ownerId, name, description, language, createdAt, forkedFrom, deleted, updatedAt, slug) <> (ProjectsRow.tupled, ProjectsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), url, ownerId, Rep.Some(name), description, language, Rep.Some(createdAt), forkedFrom, Rep.Some(deleted), Rep.Some(updatedAt), slug).shaped.<>({r=>import r._; _1.map(_=> ProjectsRow.tupled((_1.get, _2, _3, _4.get, _5, _6, _7.get, _8, _9.get, _10.get, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column url SqlType(VARCHAR), Length(255,true), Default(None) */
    val url: Rep[Option[String]] = column[Option[String]]("url", O.Length(255,varying=true), O.Default(None))
    /** Database column owner_id SqlType(INT), Default(None) */
    val ownerId: Rep[Option[Int]] = column[Option[Int]]("owner_id", O.Default(None))
    /** Database column name SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("name", O.Length(255,varying=true))
    /** Database column description SqlType(VARCHAR), Length(255,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(255,varying=true), O.Default(None))
    /** Database column language SqlType(VARCHAR), Length(255,true), Default(None) */
    val language: Rep[Option[String]] = column[Option[String]]("language", O.Length(255,varying=true), O.Default(None))
    /** Database column created_at SqlType(TIMESTAMP) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column forked_from SqlType(INT), Default(None) */
    val forkedFrom: Rep[Option[Int]] = column[Option[Int]]("forked_from", O.Default(None))
    /** Database column deleted SqlType(BIT), Default(false) */
    val deleted: Rep[Boolean] = column[Boolean]("deleted", O.Default(false))
    /** Database column updated_at SqlType(TIMESTAMP) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
    /** Database column slug SqlType(INT), Default(None) */
    val slug: Rep[Option[Int]] = column[Option[Int]]("slug", O.Default(None))

    /** Index over (name) (database name name) */
    val index1 = index("name", name)
    /** Index over (ownerId) (database name projects_ibfk_1) */
    val index2 = index("projects_ibfk_1", ownerId)
    /** Index over (forkedFrom) (database name projects_ibfk_2) */
    val index3 = index("projects_ibfk_2", forkedFrom)
    /** Index over (url) (database name url) */
    val index4 = index("url", url)
  }
  /** Collection-like TableQuery object for table Projects */
  lazy val Projects = new TableQuery(tag => new Projects(tag))

  /** Entity class storing rows of table PrsMonthlyCounts
   *  @param id Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey
   *  @param projectId Database column project_id SqlType(INT), Default(None)
   *  @param prs Database column prs SqlType(INT), Default(None)
   *  @param date Database column date SqlType(TIMESTAMP), Default(None) */
  case class PrsMonthlyCountsRow(id: Long, projectId: Option[Int] = None, prs: Option[Int] = None, date: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching PrsMonthlyCountsRow objects using plain SQL queries */
  implicit def GetResultPrsMonthlyCountsRow(implicit e0: GR[Long], e1: GR[Option[Int]], e2: GR[Option[java.sql.Timestamp]]): GR[PrsMonthlyCountsRow] = GR{
    prs => import prs._
    PrsMonthlyCountsRow.tupled((<<[Long], <<?[Int], <<?[Int], <<?[java.sql.Timestamp]))
  }
  /** Table description of table prs_monthly_counts. Objects of this class serve as prototypes for rows in queries. */
  class PrsMonthlyCounts(_tableTag: Tag) extends profile.api.Table[PrsMonthlyCountsRow](_tableTag, Some("ghtorrent"), "prs_monthly_counts") {
    def * = (id, projectId, prs, date) <> (PrsMonthlyCountsRow.tupled, PrsMonthlyCountsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), projectId, prs, date).shaped.<>({r=>import r._; _1.map(_=> PrsMonthlyCountsRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column project_id SqlType(INT), Default(None) */
    val projectId: Rep[Option[Int]] = column[Option[Int]]("project_id", O.Default(None))
    /** Database column prs SqlType(INT), Default(None) */
    val prs: Rep[Option[Int]] = column[Option[Int]]("prs", O.Default(None))
    /** Database column date SqlType(TIMESTAMP), Default(None) */
    val date: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("date", O.Default(None))

    /** Index over (date) (database name date) */
    val index1 = index("date", date)
    /** Index over (projectId) (database name project_id) */
    val index2 = index("project_id", projectId)
  }
  /** Collection-like TableQuery object for table PrsMonthlyCounts */
  lazy val PrsMonthlyCounts = new TableQuery(tag => new PrsMonthlyCounts(tag))

  /** Entity class storing rows of table PullRequestComments
   *  @param pullRequestId Database column pull_request_id SqlType(INT)
   *  @param userId Database column user_id SqlType(INT)
   *  @param commentId Database column comment_id SqlType(MEDIUMTEXT), Length(16777215,true)
   *  @param position Database column position SqlType(INT), Default(None)
   *  @param body Database column body SqlType(VARCHAR), Length(256,true), Default(None)
   *  @param commitId Database column commit_id SqlType(INT)
   *  @param createdAt Database column created_at SqlType(TIMESTAMP) */
  case class PullRequestCommentsRow(pullRequestId: Int, userId: Int, commentId: String, position: Option[Int] = None, body: Option[String] = None, commitId: Int, createdAt: java.sql.Timestamp)
  /** GetResult implicit for fetching PullRequestCommentsRow objects using plain SQL queries */
  implicit def GetResultPullRequestCommentsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[Int]], e3: GR[Option[String]], e4: GR[java.sql.Timestamp]): GR[PullRequestCommentsRow] = GR{
    prs => import prs._
    PullRequestCommentsRow.tupled((<<[Int], <<[Int], <<[String], <<?[Int], <<?[String], <<[Int], <<[java.sql.Timestamp]))
  }
  /** Table description of table pull_request_comments. Objects of this class serve as prototypes for rows in queries. */
  class PullRequestComments(_tableTag: Tag) extends profile.api.Table[PullRequestCommentsRow](_tableTag, Some("ghtorrent"), "pull_request_comments") {
    def * = (pullRequestId, userId, commentId, position, body, commitId, createdAt) <> (PullRequestCommentsRow.tupled, PullRequestCommentsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(pullRequestId), Rep.Some(userId), Rep.Some(commentId), position, body, Rep.Some(commitId), Rep.Some(createdAt)).shaped.<>({r=>import r._; _1.map(_=> PullRequestCommentsRow.tupled((_1.get, _2.get, _3.get, _4, _5, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column pull_request_id SqlType(INT) */
    val pullRequestId: Rep[Int] = column[Int]("pull_request_id")
    /** Database column user_id SqlType(INT) */
    val userId: Rep[Int] = column[Int]("user_id")
    /** Database column comment_id SqlType(MEDIUMTEXT), Length(16777215,true) */
    val commentId: Rep[String] = column[String]("comment_id", O.Length(16777215,varying=true))
    /** Database column position SqlType(INT), Default(None) */
    val position: Rep[Option[Int]] = column[Option[Int]]("position", O.Default(None))
    /** Database column body SqlType(VARCHAR), Length(256,true), Default(None) */
    val body: Rep[Option[String]] = column[Option[String]]("body", O.Length(256,varying=true), O.Default(None))
    /** Database column commit_id SqlType(INT) */
    val commitId: Rep[Int] = column[Int]("commit_id")
    /** Database column created_at SqlType(TIMESTAMP) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")

    /** Index over (pullRequestId) (database name pull_request_comments_ibfk_1) */
    val index1 = index("pull_request_comments_ibfk_1", pullRequestId)
    /** Index over (userId) (database name pull_request_comments_ibfk_2) */
    val index2 = index("pull_request_comments_ibfk_2", userId)
    /** Index over (commitId) (database name pull_request_comments_ibfk_3) */
    val index3 = index("pull_request_comments_ibfk_3", commitId)
  }
  /** Collection-like TableQuery object for table PullRequestComments */
  lazy val PullRequestComments = new TableQuery(tag => new PullRequestComments(tag))

  /** Entity class storing rows of table PullRequestCommits
   *  @param pullRequestId Database column pull_request_id SqlType(INT)
   *  @param commitId Database column commit_id SqlType(INT) */
  case class PullRequestCommitsRow(pullRequestId: Int, commitId: Int)
  /** GetResult implicit for fetching PullRequestCommitsRow objects using plain SQL queries */
  implicit def GetResultPullRequestCommitsRow(implicit e0: GR[Int]): GR[PullRequestCommitsRow] = GR{
    prs => import prs._
    PullRequestCommitsRow.tupled((<<[Int], <<[Int]))
  }
  /** Table description of table pull_request_commits. Objects of this class serve as prototypes for rows in queries. */
  class PullRequestCommits(_tableTag: Tag) extends profile.api.Table[PullRequestCommitsRow](_tableTag, Some("ghtorrent"), "pull_request_commits") {
    def * = (pullRequestId, commitId) <> (PullRequestCommitsRow.tupled, PullRequestCommitsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(pullRequestId), Rep.Some(commitId)).shaped.<>({r=>import r._; _1.map(_=> PullRequestCommitsRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column pull_request_id SqlType(INT) */
    val pullRequestId: Rep[Int] = column[Int]("pull_request_id")
    /** Database column commit_id SqlType(INT) */
    val commitId: Rep[Int] = column[Int]("commit_id")

    /** Primary key of PullRequestCommits (database name pull_request_commits_PK) */
    val pk = primaryKey("pull_request_commits_PK", (pullRequestId, commitId))

    /** Index over (commitId) (database name pull_request_commits_ibfk_2) */
    val index1 = index("pull_request_commits_ibfk_2", commitId)
  }
  /** Collection-like TableQuery object for table PullRequestCommits */
  lazy val PullRequestCommits = new TableQuery(tag => new PullRequestCommits(tag))

  /** Entity class storing rows of table PullRequestHistory
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param pullRequestId Database column pull_request_id SqlType(INT)
   *  @param createdAt Database column created_at SqlType(TIMESTAMP)
   *  @param action Database column action SqlType(VARCHAR), Length(255,true)
   *  @param actorId Database column actor_id SqlType(INT), Default(None) */
  case class PullRequestHistoryRow(id: Int, pullRequestId: Int, createdAt: java.sql.Timestamp, action: String, actorId: Option[Int] = None)
  /** GetResult implicit for fetching PullRequestHistoryRow objects using plain SQL queries */
  implicit def GetResultPullRequestHistoryRow(implicit e0: GR[Int], e1: GR[java.sql.Timestamp], e2: GR[String], e3: GR[Option[Int]]): GR[PullRequestHistoryRow] = GR{
    prs => import prs._
    PullRequestHistoryRow.tupled((<<[Int], <<[Int], <<[java.sql.Timestamp], <<[String], <<?[Int]))
  }
  /** Table description of table pull_request_history. Objects of this class serve as prototypes for rows in queries. */
  class PullRequestHistory(_tableTag: Tag) extends profile.api.Table[PullRequestHistoryRow](_tableTag, Some("ghtorrent"), "pull_request_history") {
    def * = (id, pullRequestId, createdAt, action, actorId) <> (PullRequestHistoryRow.tupled, PullRequestHistoryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(pullRequestId), Rep.Some(createdAt), Rep.Some(action), actorId).shaped.<>({r=>import r._; _1.map(_=> PullRequestHistoryRow.tupled((_1.get, _2.get, _3.get, _4.get, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column pull_request_id SqlType(INT) */
    val pullRequestId: Rep[Int] = column[Int]("pull_request_id")
    /** Database column created_at SqlType(TIMESTAMP) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column action SqlType(VARCHAR), Length(255,true) */
    val action: Rep[String] = column[String]("action", O.Length(255,varying=true))
    /** Database column actor_id SqlType(INT), Default(None) */
    val actorId: Rep[Option[Int]] = column[Option[Int]]("actor_id", O.Default(None))

    /** Index over (pullRequestId) (database name pull_request_history_ibfk_1) */
    val index1 = index("pull_request_history_ibfk_1", pullRequestId)
    /** Index over (actorId) (database name pull_request_history_ibfk_2) */
    val index2 = index("pull_request_history_ibfk_2", actorId)
  }
  /** Collection-like TableQuery object for table PullRequestHistory */
  lazy val PullRequestHistory = new TableQuery(tag => new PullRequestHistory(tag))

  /** Entity class storing rows of table PullRequests
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param headRepoId Database column head_repo_id SqlType(INT), Default(None)
   *  @param baseRepoId Database column base_repo_id SqlType(INT)
   *  @param headCommitId Database column head_commit_id SqlType(INT), Default(None)
   *  @param baseCommitId Database column base_commit_id SqlType(INT)
   *  @param pullreqId Database column pullreq_id SqlType(INT)
   *  @param intraBranch Database column intra_branch SqlType(BIT) */
  case class PullRequestsRow(id: Int, headRepoId: Option[Int] = None, baseRepoId: Int, headCommitId: Option[Int] = None, baseCommitId: Int, pullreqId: Int, intraBranch: Boolean)
  /** GetResult implicit for fetching PullRequestsRow objects using plain SQL queries */
  implicit def GetResultPullRequestsRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Boolean]): GR[PullRequestsRow] = GR{
    prs => import prs._
    PullRequestsRow.tupled((<<[Int], <<?[Int], <<[Int], <<?[Int], <<[Int], <<[Int], <<[Boolean]))
  }
  /** Table description of table pull_requests. Objects of this class serve as prototypes for rows in queries. */
  class PullRequests(_tableTag: Tag) extends profile.api.Table[PullRequestsRow](_tableTag, Some("ghtorrent"), "pull_requests") {
    def * = (id, headRepoId, baseRepoId, headCommitId, baseCommitId, pullreqId, intraBranch) <> (PullRequestsRow.tupled, PullRequestsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), headRepoId, Rep.Some(baseRepoId), headCommitId, Rep.Some(baseCommitId), Rep.Some(pullreqId), Rep.Some(intraBranch)).shaped.<>({r=>import r._; _1.map(_=> PullRequestsRow.tupled((_1.get, _2, _3.get, _4, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column head_repo_id SqlType(INT), Default(None) */
    val headRepoId: Rep[Option[Int]] = column[Option[Int]]("head_repo_id", O.Default(None))
    /** Database column base_repo_id SqlType(INT) */
    val baseRepoId: Rep[Int] = column[Int]("base_repo_id")
    /** Database column head_commit_id SqlType(INT), Default(None) */
    val headCommitId: Rep[Option[Int]] = column[Option[Int]]("head_commit_id", O.Default(None))
    /** Database column base_commit_id SqlType(INT) */
    val baseCommitId: Rep[Int] = column[Int]("base_commit_id")
    /** Database column pullreq_id SqlType(INT) */
    val pullreqId: Rep[Int] = column[Int]("pullreq_id")
    /** Database column intra_branch SqlType(BIT) */
    val intraBranch: Rep[Boolean] = column[Boolean]("intra_branch")

    /** Index over (headRepoId) (database name pull_requests_ibfk_1) */
    val index1 = index("pull_requests_ibfk_1", headRepoId)
    /** Index over (baseRepoId) (database name pull_requests_ibfk_2) */
    val index2 = index("pull_requests_ibfk_2", baseRepoId)
    /** Index over (headCommitId) (database name pull_requests_ibfk_3) */
    val index3 = index("pull_requests_ibfk_3", headCommitId)
    /** Index over (baseCommitId) (database name pull_requests_ibfk_4) */
    val index4 = index("pull_requests_ibfk_4", baseCommitId)
    /** Uniqueness Index over (pullreqId,baseRepoId) (database name pullreq_id) */
    val index5 = index("pullreq_id", (pullreqId, baseRepoId), unique=true)
  }
  /** Collection-like TableQuery object for table PullRequests */
  lazy val PullRequests = new TableQuery(tag => new PullRequests(tag))

  /** Entity class storing rows of table RepoLabels
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param repoId Database column repo_id SqlType(INT), Default(None)
   *  @param name Database column name SqlType(VARCHAR), Length(24,true) */
  case class RepoLabelsRow(id: Int, repoId: Option[Int] = None, name: String)
  /** GetResult implicit for fetching RepoLabelsRow objects using plain SQL queries */
  implicit def GetResultRepoLabelsRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[String]): GR[RepoLabelsRow] = GR{
    prs => import prs._
    RepoLabelsRow.tupled((<<[Int], <<?[Int], <<[String]))
  }
  /** Table description of table repo_labels. Objects of this class serve as prototypes for rows in queries. */
  class RepoLabels(_tableTag: Tag) extends profile.api.Table[RepoLabelsRow](_tableTag, Some("ghtorrent"), "repo_labels") {
    def * = (id, repoId, name) <> (RepoLabelsRow.tupled, RepoLabelsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), repoId, Rep.Some(name)).shaped.<>({r=>import r._; _1.map(_=> RepoLabelsRow.tupled((_1.get, _2, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column repo_id SqlType(INT), Default(None) */
    val repoId: Rep[Option[Int]] = column[Option[Int]]("repo_id", O.Default(None))
    /** Database column name SqlType(VARCHAR), Length(24,true) */
    val name: Rep[String] = column[String]("name", O.Length(24,varying=true))

    /** Index over (repoId) (database name repo_labels_ibfk_1) */
    val index1 = index("repo_labels_ibfk_1", repoId)
  }
  /** Collection-like TableQuery object for table RepoLabels */
  lazy val RepoLabels = new TableQuery(tag => new RepoLabels(tag))

  /** Entity class storing rows of table RepoMilestones
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param repoId Database column repo_id SqlType(INT), Default(None)
   *  @param name Database column name SqlType(VARCHAR), Length(24,true) */
  case class RepoMilestonesRow(id: Int, repoId: Option[Int] = None, name: String)
  /** GetResult implicit for fetching RepoMilestonesRow objects using plain SQL queries */
  implicit def GetResultRepoMilestonesRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[String]): GR[RepoMilestonesRow] = GR{
    prs => import prs._
    RepoMilestonesRow.tupled((<<[Int], <<?[Int], <<[String]))
  }
  /** Table description of table repo_milestones. Objects of this class serve as prototypes for rows in queries. */
  class RepoMilestones(_tableTag: Tag) extends profile.api.Table[RepoMilestonesRow](_tableTag, Some("ghtorrent"), "repo_milestones") {
    def * = (id, repoId, name) <> (RepoMilestonesRow.tupled, RepoMilestonesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), repoId, Rep.Some(name)).shaped.<>({r=>import r._; _1.map(_=> RepoMilestonesRow.tupled((_1.get, _2, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column repo_id SqlType(INT), Default(None) */
    val repoId: Rep[Option[Int]] = column[Option[Int]]("repo_id", O.Default(None))
    /** Database column name SqlType(VARCHAR), Length(24,true) */
    val name: Rep[String] = column[String]("name", O.Length(24,varying=true))

    /** Index over (repoId) (database name repo_milestones_ibfk_1) */
    val index1 = index("repo_milestones_ibfk_1", repoId)
  }
  /** Collection-like TableQuery object for table RepoMilestones */
  lazy val RepoMilestones = new TableQuery(tag => new RepoMilestones(tag))

  /** Entity class storing rows of table RootsForks
   *  @param id Database column id SqlType(INT), PrimaryKey
   *  @param forks Database column forks SqlType(TEXT) */
  case class RootsForksRow(id: Int, forks: String)
  /** GetResult implicit for fetching RootsForksRow objects using plain SQL queries */
  implicit def GetResultRootsForksRow(implicit e0: GR[Int], e1: GR[String]): GR[RootsForksRow] = GR{
    prs => import prs._
    RootsForksRow.tupled((<<[Int], <<[String]))
  }
  /** Table description of table roots_forks. Objects of this class serve as prototypes for rows in queries. */
  class RootsForks(_tableTag: Tag) extends profile.api.Table[RootsForksRow](_tableTag, Some("ghtorrent"), "roots_forks") {
    def * = (id, forks) <> (RootsForksRow.tupled, RootsForksRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(forks)).shaped.<>({r=>import r._; _1.map(_=> RootsForksRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.PrimaryKey)
    /** Database column forks SqlType(TEXT) */
    val forks: Rep[String] = column[String]("forks")
  }
  /** Collection-like TableQuery object for table RootsForks */
  lazy val RootsForks = new TableQuery(tag => new RootsForks(tag))

  /** Entity class storing rows of table RootsForksS
   *  @param id Database column id SqlType(INT), PrimaryKey
   *  @param forks Database column forks SqlType(TEXT) */
  case class RootsForksSRow(id: Int, forks: String)
  /** GetResult implicit for fetching RootsForksSRow objects using plain SQL queries */
  implicit def GetResultRootsForksSRow(implicit e0: GR[Int], e1: GR[String]): GR[RootsForksSRow] = GR{
    prs => import prs._
    RootsForksSRow.tupled((<<[Int], <<[String]))
  }
  /** Table description of table roots_forks_s. Objects of this class serve as prototypes for rows in queries. */
  class RootsForksS(_tableTag: Tag) extends profile.api.Table[RootsForksSRow](_tableTag, Some("ghtorrent"), "roots_forks_s") {
    def * = (id, forks) <> (RootsForksSRow.tupled, RootsForksSRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(forks)).shaped.<>({r=>import r._; _1.map(_=> RootsForksSRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.PrimaryKey)
    /** Database column forks SqlType(TEXT) */
    val forks: Rep[String] = column[String]("forks")
  }
  /** Collection-like TableQuery object for table RootsForksS */
  lazy val RootsForksS = new TableQuery(tag => new RootsForksS(tag))

  /** Entity class storing rows of table SchemaInfo
   *  @param version Database column version SqlType(INT), Default(0) */
  case class SchemaInfoRow(version: Int = 0)
  /** GetResult implicit for fetching SchemaInfoRow objects using plain SQL queries */
  implicit def GetResultSchemaInfoRow(implicit e0: GR[Int]): GR[SchemaInfoRow] = GR{
    prs => import prs._
    SchemaInfoRow(<<[Int])
  }
  /** Table description of table schema_info. Objects of this class serve as prototypes for rows in queries. */
  class SchemaInfo(_tableTag: Tag) extends profile.api.Table[SchemaInfoRow](_tableTag, Some("ghtorrent"), "schema_info") {
    def * = version <> (SchemaInfoRow, SchemaInfoRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = Rep.Some(version).shaped.<>(r => r.map(_=> SchemaInfoRow(r.get)), (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column version SqlType(INT), Default(0) */
    val version: Rep[Int] = column[Int]("version", O.Default(0))
  }
  /** Collection-like TableQuery object for table SchemaInfo */
  lazy val SchemaInfo = new TableQuery(tag => new SchemaInfo(tag))

  /** Entity class storing rows of table TmpTravisRepos
   *  @param id Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey
   *  @param packagename Database column packagename SqlType(VARCHAR), Length(512,true), Default(None) */
  case class TmpTravisReposRow(id: Long, packagename: Option[String] = None)
  /** GetResult implicit for fetching TmpTravisReposRow objects using plain SQL queries */
  implicit def GetResultTmpTravisReposRow(implicit e0: GR[Long], e1: GR[Option[String]]): GR[TmpTravisReposRow] = GR{
    prs => import prs._
    TmpTravisReposRow.tupled((<<[Long], <<?[String]))
  }
  /** Table description of table tmp_travis_repos. Objects of this class serve as prototypes for rows in queries. */
  class TmpTravisRepos(_tableTag: Tag) extends profile.api.Table[TmpTravisReposRow](_tableTag, Some("ghtorrent"), "tmp_travis_repos") {
    def * = (id, packagename) <> (TmpTravisReposRow.tupled, TmpTravisReposRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), packagename).shaped.<>({r=>import r._; _1.map(_=> TmpTravisReposRow.tupled((_1.get, _2)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column packagename SqlType(VARCHAR), Length(512,true), Default(None) */
    val packagename: Rep[Option[String]] = column[Option[String]]("packagename", O.Length(512,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table TmpTravisRepos */
  lazy val TmpTravisRepos = new TableQuery(tag => new TmpTravisRepos(tag))

  /** Entity class storing rows of table Users
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param login Database column login SqlType(VARCHAR), Length(255,true)
   *  @param company Database column company SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param createdAt Database column created_at SqlType(TIMESTAMP)
   *  @param `type` Database column type SqlType(VARCHAR), Length(255,true), Default(USR)
   *  @param fake Database column fake SqlType(BIT), Default(false)
   *  @param deleted Database column deleted SqlType(BIT), Default(false)
   *  @param long Database column long SqlType(DECIMAL), Default(None)
   *  @param lat Database column lat SqlType(DECIMAL), Default(None)
   *  @param countryCode Database column country_code SqlType(CHAR), Length(3,false), Default(None)
   *  @param state Database column state SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param city Database column city SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param location Database column location SqlType(VARCHAR), Length(255,true), Default(None) */
  case class UsersRow(id: Int, login: String, company: Option[String] = None, createdAt: java.sql.Timestamp, `type`: String = "USR", fake: Boolean = false, deleted: Boolean = false, long: Option[scala.math.BigDecimal] = None, lat: Option[scala.math.BigDecimal] = None, countryCode: Option[String] = None, state: Option[String] = None, city: Option[String] = None, location: Option[String] = None)
  /** GetResult implicit for fetching UsersRow objects using plain SQL queries */
  implicit def GetResultUsersRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]], e3: GR[java.sql.Timestamp], e4: GR[Boolean], e5: GR[Option[scala.math.BigDecimal]]): GR[UsersRow] = GR{
    prs => import prs._
    UsersRow.tupled((<<[Int], <<[String], <<?[String], <<[java.sql.Timestamp], <<[String], <<[Boolean], <<[Boolean], <<?[scala.math.BigDecimal], <<?[scala.math.BigDecimal], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table users. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class Users(_tableTag: Tag) extends profile.api.Table[UsersRow](_tableTag, Some("ghtorrent"), "users") {
    def * = (id, login, company, createdAt, `type`, fake, deleted, long, lat, countryCode, state, city, location) <> (UsersRow.tupled, UsersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(login), company, Rep.Some(createdAt), Rep.Some(`type`), Rep.Some(fake), Rep.Some(deleted), long, lat, countryCode, state, city, location).shaped.<>({r=>import r._; _1.map(_=> UsersRow.tupled((_1.get, _2.get, _3, _4.get, _5.get, _6.get, _7.get, _8, _9, _10, _11, _12, _13)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column login SqlType(VARCHAR), Length(255,true) */
    val login: Rep[String] = column[String]("login", O.Length(255,varying=true))
    /** Database column company SqlType(VARCHAR), Length(255,true), Default(None) */
    val company: Rep[Option[String]] = column[Option[String]]("company", O.Length(255,varying=true), O.Default(None))
    /** Database column created_at SqlType(TIMESTAMP) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column type SqlType(VARCHAR), Length(255,true), Default(USR)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[String] = column[String]("type", O.Length(255,varying=true), O.Default("USR"))
    /** Database column fake SqlType(BIT), Default(false) */
    val fake: Rep[Boolean] = column[Boolean]("fake", O.Default(false))
    /** Database column deleted SqlType(BIT), Default(false) */
    val deleted: Rep[Boolean] = column[Boolean]("deleted", O.Default(false))
    /** Database column long SqlType(DECIMAL), Default(None) */
    val long: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("long", O.Default(None))
    /** Database column lat SqlType(DECIMAL), Default(None) */
    val lat: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("lat", O.Default(None))
    /** Database column country_code SqlType(CHAR), Length(3,false), Default(None) */
    val countryCode: Rep[Option[String]] = column[Option[String]]("country_code", O.Length(3,varying=false), O.Default(None))
    /** Database column state SqlType(VARCHAR), Length(255,true), Default(None) */
    val state: Rep[Option[String]] = column[Option[String]]("state", O.Length(255,varying=true), O.Default(None))
    /** Database column city SqlType(VARCHAR), Length(255,true), Default(None) */
    val city: Rep[Option[String]] = column[Option[String]]("city", O.Length(255,varying=true), O.Default(None))
    /** Database column location SqlType(VARCHAR), Length(255,true), Default(None) */
    val location: Rep[Option[String]] = column[Option[String]]("location", O.Length(255,varying=true), O.Default(None))

    /** Uniqueness Index over (login) (database name login) */
    val index1 = index("login", login, unique=true)
  }
  /** Collection-like TableQuery object for table Users */
  lazy val Users = new TableQuery(tag => new Users(tag))

  /** Entity class storing rows of table Watchers
   *  @param repoId Database column repo_id SqlType(INT)
   *  @param userId Database column user_id SqlType(INT)
   *  @param createdAt Database column created_at SqlType(TIMESTAMP) */
  case class WatchersRow(repoId: Int, userId: Int, createdAt: java.sql.Timestamp)
  /** GetResult implicit for fetching WatchersRow objects using plain SQL queries */
  implicit def GetResultWatchersRow(implicit e0: GR[Int], e1: GR[java.sql.Timestamp]): GR[WatchersRow] = GR{
    prs => import prs._
    WatchersRow.tupled((<<[Int], <<[Int], <<[java.sql.Timestamp]))
  }
  /** Table description of table watchers. Objects of this class serve as prototypes for rows in queries. */
  class Watchers(_tableTag: Tag) extends profile.api.Table[WatchersRow](_tableTag, Some("ghtorrent"), "watchers") {
    def * = (repoId, userId, createdAt) <> (WatchersRow.tupled, WatchersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(repoId), Rep.Some(userId), Rep.Some(createdAt)).shaped.<>({r=>import r._; _1.map(_=> WatchersRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column repo_id SqlType(INT) */
    val repoId: Rep[Int] = column[Int]("repo_id")
    /** Database column user_id SqlType(INT) */
    val userId: Rep[Int] = column[Int]("user_id")
    /** Database column created_at SqlType(TIMESTAMP) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")

    /** Primary key of Watchers (database name watchers_PK) */
    val pk = primaryKey("watchers_PK", (repoId, userId))

    /** Index over (userId) (database name watchers_ibfk_2) */
    val index1 = index("watchers_ibfk_2", userId)
  }
  /** Collection-like TableQuery object for table Watchers */
  lazy val Watchers = new TableQuery(tag => new Watchers(tag))

  /** Entity class storing rows of table WatchersCount
   *  @param repoId Database column repo_id SqlType(INT), PrimaryKey
   *  @param createdAt Database column created_at SqlType(TIMESTAMP)
   *  @param watchersCount Database column watchers_count SqlType(BIGINT), Default(0) */
  case class WatchersCountRow(repoId: Int, createdAt: java.sql.Timestamp, watchersCount: Long = 0L)
  /** GetResult implicit for fetching WatchersCountRow objects using plain SQL queries */
  implicit def GetResultWatchersCountRow(implicit e0: GR[Int], e1: GR[java.sql.Timestamp], e2: GR[Long]): GR[WatchersCountRow] = GR{
    prs => import prs._
    WatchersCountRow.tupled((<<[Int], <<[java.sql.Timestamp], <<[Long]))
  }
  /** Table description of table watchers_count. Objects of this class serve as prototypes for rows in queries. */
  class WatchersCount(_tableTag: Tag) extends profile.api.Table[WatchersCountRow](_tableTag, Some("ghtorrent"), "watchers_count") {
    def * = (repoId, createdAt, watchersCount) <> (WatchersCountRow.tupled, WatchersCountRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(repoId), Rep.Some(createdAt), Rep.Some(watchersCount)).shaped.<>({r=>import r._; _1.map(_=> WatchersCountRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column repo_id SqlType(INT), PrimaryKey */
    val repoId: Rep[Int] = column[Int]("repo_id", O.PrimaryKey)
    /** Database column created_at SqlType(TIMESTAMP) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column watchers_count SqlType(BIGINT), Default(0) */
    val watchersCount: Rep[Long] = column[Long]("watchers_count", O.Default(0L))

    /** Index over (watchersCount) (database name watchers_count) */
    val index1 = index("watchers_count", watchersCount)
  }
  /** Collection-like TableQuery object for table WatchersCount */
  lazy val WatchersCount = new TableQuery(tag => new WatchersCount(tag))

  /** Entity class storing rows of table WatchersMonthlyCounts
   *  @param projectId Database column project_id SqlType(INT), Default(None)
   *  @param watchers Database column watchers SqlType(INT), Default(None)
   *  @param date Database column date SqlType(TIMESTAMP), Default(None) */
  case class WatchersMonthlyCountsRow(projectId: Option[Int] = None, watchers: Option[Int] = None, date: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching WatchersMonthlyCountsRow objects using plain SQL queries */
  implicit def GetResultWatchersMonthlyCountsRow(implicit e0: GR[Option[Int]], e1: GR[Option[java.sql.Timestamp]]): GR[WatchersMonthlyCountsRow] = GR{
    prs => import prs._
    WatchersMonthlyCountsRow.tupled((<<?[Int], <<?[Int], <<?[java.sql.Timestamp]))
  }
  /** Table description of table watchers_monthly_counts. Objects of this class serve as prototypes for rows in queries. */
  class WatchersMonthlyCounts(_tableTag: Tag) extends profile.api.Table[WatchersMonthlyCountsRow](_tableTag, Some("ghtorrent"), "watchers_monthly_counts") {
    def * = (projectId, watchers, date) <> (WatchersMonthlyCountsRow.tupled, WatchersMonthlyCountsRow.unapply)

    /** Database column project_id SqlType(INT), Default(None) */
    val projectId: Rep[Option[Int]] = column[Option[Int]]("project_id", O.Default(None))
    /** Database column watchers SqlType(INT), Default(None) */
    val watchers: Rep[Option[Int]] = column[Option[Int]]("watchers", O.Default(None))
    /** Database column date SqlType(TIMESTAMP), Default(None) */
    val date: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("date", O.Default(None))

    /** Index over (date) (database name date) */
    val index1 = index("date", date)
    /** Index over (projectId) (database name project_id) */
    val index2 = index("project_id", projectId)
  }
  /** Collection-like TableQuery object for table WatchersMonthlyCounts */
  lazy val WatchersMonthlyCounts = new TableQuery(tag => new WatchersMonthlyCounts(tag))
}
