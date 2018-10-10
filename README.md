
# Forelesning 7

## Oppgave 1: Lagre data i PostgreSQL


Du må installere PostgreSQL før du starter med oppgaven. Det kan du gjøre herfra: https://www.postgresql.org/. PostgreSQL er en open source database med bedre ytelse og stabilitet enn MySQL og en av de mest populære databasene i seriøse prosjekter.

Du trenger også en databaseklient. Jeg anbefaler DBeaver som du kan installere herfra: https://dbeaver.io/ DBeaver er open source og støtter en stor rekke databaser. Den har også mulighet til å generere visuelle databaseskjemaer, utforske databaser og mye mer.

I prosjektet finnes det en fil `no.kristiania.pgr200.database.ConferenceDatabaseProgram`. **Første oppgave er å få denne til å kjøre og lagre data i PostgreSQL databasen**.

For at dette skal fungere må du:

1. Installere PostgreSQL og DBeaver
2. Koble deg til PostgreSQL med DBeaver
3. Opprette en databasebruker
4. Opprette en logisk database i databaseserveren
5. Kjøre `ConferenceDatabaseProgram`
6. Sjekke at det har kommet data i PostgreSQL ved hjelp av DBeaver

Her er flere detaljer:

* For å koble DBeaver til PostgreSQL, velg File > New > DBeaver > Database Connection
  Du skal benytte brukernavnet `postgres` og passorder du satte når du installerte PostgreSQL
* For å opprette en databasebruker skal du bruke kommandoen [CREATE USER](https://www.postgresql.org/docs/current/static/sql-createuser.html).
  Benytt brukernavn og passord som du finner i `ConferenceDatabaseProgram.createDataSource`
* For å opprette en logisk database skal du bruke kommandoen [CREATE DATABASE](https://www.postgresql.org/docs/current/static/sql-createdatabase.html).
  Bruk navnet `conferencedb_test` på databasen
* Når du starter `ConferenceDatabaseCommand` må du angi er argument "insert"
* Du kan så utforske tabellene i DBeaver (men du må først høyreklikke på Database Navigator objektene og velge Refresh)
* Du kan også utføre kommandoen `SELECT * FROM CONFERENCE_TALK` i et SQL Editor vindu i DBeaver


## Oppgave 2: Laste ut data fra databasen

Kommandoen `select * from CONFERENCE_TALK` lister opp alle radene i `CONFERENCE_TALK` tabellen. Implementer en kommando i `ConferenceDatabaseProgram` som utfører denne kommandoen og skrive ut radene.

Tips: Du bør bruke `Connection#prepareStatement` og `PreparedStatement#executeQuery` for å få tak i et `ResultSet` objekt. Benytt `ResultSet#next` og `ResultSet#getString` for å hente ut data fra `ResultSet`.  For denne oppgaven trenger du å opprette en ny klasse som representerer en Conference Talk.


## Oppgave 3: Oppdater `ConferenceTalksDaoTest`

`ConferenceTalksDaoTest` kan også sjekke at data som har blitt lagt inn kan hentes ut igjen. Endre testen `shouldInsertConferenceTalks` til å ta med dette.

## Oppgave 4: Innfør et autogenerert `id` felt for `CONFERENCE_TALK`

# Forelesning 8

## Oppgave 5: Bruk Flyway til å lagre basebaseskjema

Legg til dependency på `org.flywaydb:flywaydb` i `pom.xml` for å ta i bruk Flyway. Flytt `CREATE TABLE` statements fra Java kode til migration scripts. Se [Flyway dokumentasjon](https://flywaydb.org/getstarted/firststeps/api).

## Oppgave 6: Innfør flere tabeller

`CONFERENCE_TALKS` kan være koblet til en eller flere `TOPICS`. Legg til kommandoer for å opprette en topic, koble en topic til en talk og liste alle talks som har en gitt topic. Bruk en join tabell mellom `CONFERENCE_TALKS` og `TOPICS`. Bruk DAO-patternet for å implementere TopicsDao.

## Oppgave 7: Splitt prosjektet i to Maven-moduler (neste uke)

DAO-er og testkode for disse skal flyttes til en ny undermodul som heter `database-core`, main-klasser skal flyttes til en ny undermodul som heter `database-main`. Denne katalogen skal gjøres om til et Maven [multi-module prosjekt](https://books.sonatype.com/mvnex-book/reference/multimodule.html).

For å bygge begge modulene står du i hovedpakka og skriver `mvn install`.

## Oppgave 8: Gjør `database-main` eksekverbar (neste uke)

Etter at du har kjørt `mvn install` ønsker vi at `database-main.jar`-fila skal kunne kjøres med `java -jar database-main.jar`. For å få dette til må du benytte [Maven Shade Plugin](https://maven.apache.org/plugins/maven-shade-plugin/examples/executable-jar.html).

## Oppgave 9: Beskriv designretningslinjer tekstlig

Når du oppretter migrations og skriver `CREATE TABLE` statements (oppgave 5) og når du lager DAO-er og DataObjekter er det lurt å gjøre det på samme måte for alle tabeller og klasser innenfor et prosjekt. Beskriv i README-fila hvilke retningslinjer for navn, DAO-metoder, primærnøkler og fremmednøkler du har fulgt.

## Oppgave 10: Trekk ut en felles superklasse fra ConferenceTalksDao og TopicsDao (valgfri)

AbstractDao kan implementere listObjects(), singleObject(), executeUpdate() ved hjelp av en "template method" eller lambda.

## Oppgave 11: Kjør prosjektet dittt i Travis-CI (valgfri)
