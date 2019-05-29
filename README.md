# connection_leak
Spring Boot+Hibernate+Postgres unwrap connection leak


Create test data:
http://localhost:8080/create?number=1500

Make successful calls:
http://localhost:8080/success

Create calls that make connection leaks (not closed and will cause an JDBC connection timeout after for eg. 40 calls)
http://localhost:8080/fail
