
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

Tips: Du bør bruke `Connection#prepareStatement` og `PreparedStatement#executeQuery` for å få tak i et `ResultSet` objekt. Benytt `ResultSet#next` og `ResultSet#getString` for å hente ut data fra `ResultSet`.


## Oppgave 3: Oppdater `ConferenceTalksDaoTest`

`ConferenceTalksDaoTest` kan også sjekke at data som har blitt lagt inn kan hentes ut igjen. Endre testen `shouldInsertConferenceTalks` til å ta med dette. For denne oppgaven trenger du å opprette en ny klasse som representerer en Conference Talk.

## Oppgave 4: Innfør et autogenerert `id` felt for `CONFERENCE_TALK`




