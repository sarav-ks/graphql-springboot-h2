# graphql-springboot-h2
Sample Book Recommendation App using GraphQL / SpringBoot / JPA / MapStruct / H2

### Below are the model objects:

1) Author (name, email , city , state , country)
2) Book (id , name , authors ,genres, sample)
3) BookReview (book,reviewer,rating,awards)


### Model Relationship :

- Book to Author (Many to Many)
- Book to Review (One to Many)

### Graph QL APIs :

- Create Author
```
mutation {
  createAuthor(name: "Author1", email: "auth1@abc.com", city: "C" , state: "S", country: "CC") { id , name }
}
```
- Create Book 
```
mutation {
  createBook(name: "Graph QL", authors: [1,2], genres: "Technology") { id , name }
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
  createReview(book: 1, reviewer: "rev1", rating: 2, awards: ["NY Best Seller","Best Book of Year"]) { book , rating }
}
```
