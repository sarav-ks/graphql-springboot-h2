# graphql-springboot-h2
Sample Book Recommendation App using GraphQL / SpringBoot / JPA / MapStruct / H2

### Below are the model objects:

1) Author (name, email , city , state , country)
2) Book (id , name , authors ,genres, sample,awards)
3) BookReview (book,reviewer,rating)


### Model Relationship :

- Book to Author (Many to Many)
- Book to Review (One to Many)

### Graph QL APIs :

- Create Author
```
mutation {
  createAuthor(name: "Author1", email: "auth1@abc.com", city: "C" , state: "S", country: "CC") { name, email }
}
```
- Create Book 
```
mutation {
  createBook(name: "Graph QL", authors: [1,2], genres: "Technology", awards: ["NY Best Seller","Best Book of Year"]) { id , name }
}
```
```
mutation {
  createBook(name: "Big Nate", authors: [1], genres: "Children", sample: "Sample chapters from the book") { id , name }
}
```
- Create Review

```
mutation {
  createReview(book: 1, reviewer: "rev1", rating: 2) { book {name} , rating, reviewer }
}
```

- **Query** for Book Recommendation

```
query {
  recommendBook(authorname: "Author1") { book {id, name} , rating }
}
```
- **Update** Book to Add awards
```
mutation {
  updateBook(id: 2, awards: ["Best Kids Book of Year"]) { name, awards }
}

### To run 

```
$ curl \
> --request POST 'localhost:8080/graphql' \
> --header 'Content-Type: application/json' \
> --data-raw '{"query":"mutation {\n  createAuthor(name: \"Author1\", email: \"auth1@abc.com\", city: \"C\" , state: \"S\", country: \"CC\") { name, email }\n}"}'
```