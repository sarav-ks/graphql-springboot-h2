# graphql-springboot-h2
Sample Book Recommendation App using GraphQL / SpringBoot / JPA / MapStruct / H2

Below are the model objects:

1) Book (id , name , authors ,genres, sample)
2) BookReview (id,reviewer,rating,awards)
3) Author (name, email , city , state , country)

Model Relationship :

Book to Author (Many to Many)
Book to Review (One to Many)
