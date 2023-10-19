
*Problem to Solve*
Existing software to develop E-Learning courses allow the instructional designer to add 
the content to teach, but no way to track that content.  It would be preferable if quiz 
questions for example would be tied to the snippets of information that are taught to the 
user, which would in turn be tied to learning objectives. That way, at the end of the course,
we could give the trainee not only a quiz score, but a list of all the areas that they need 
to improve on or work on. It will allow the trainer to assess which parts of their training 
needs more work. 

*This Application*
We have a Java backend and a React front end which is in a separate repo. 
The application is data driven, meaning that every bit of information displayed on the 
screen for the user, originates in the database, nothing is hard coded. 

A teacher usually teaches many different types of courses. For example, I am able
to teach both programming and sewing.  

Each course is made up of a set of lessons. 

Imagine a lesson as a Power Point slide deck. A lesson therefore, is made up of a series 
of pages. 

Each slide or page, contains a set of content to be taught. This can be facts, bullet points etc. 



*How Data is Organized*

**Course** - E.G. Java, Sewing, Web Development  
**Subject** - E.G. Sewing basics, HTML, CSS  
**Lesson** - E.G. Threading the machine, Constructors  
**Page** - A lesson is made up of pages  
**PageContent** - A page is made up of PageContent items  
**Content** - E.G. 'Java is an Object Oriented language' 
Content is the super class of different types e.g. Fact, Definition etc.   


