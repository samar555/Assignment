# Assignment
Quizz API assignment for a Compony <br>
# download
you have to download the project as zip

extract it open vs code and import folder or use another ide 

# connectivity of database
setup your datbase Connection like userName and password use My sql Database.

run Your Project

 # Call API
now open postman 
# add raw data to quiz
POST /quizzes - to create a new quiz <br>
{
  "question": "What is the capital of France?",
  "optionsOfAnswer": ["London", "Paris", "Berlin", "Madrid"],
  "indexofCorrectAnswer": 1,
  "startDate": "2023-05-29T08:00:00",
  "endDate": "2023-06-02T12:00:00"
}
<br>

GET /quizzes/active - to retrieve the active quiz (the quiz that is currently within its start and end time) <br>
GET /quizzes/:id/result - to retrieve the result of a quiz by its ID <br>
GET /quizzes/all - to retrieve the all quizes <br>

these will return related answer
