USE omelette_db;


INSERT INTO chef_profile(bio, firstName, lastName, phone, picture, video, user_id)
VALUES("biographybiographybiographybiographybiographybiography", "billy", "smith", 7709987654, "picturepicturepicture", "videovideovideovideo", 1),
  ("biographybiographybiographybiographybiographybiography", "billy", "smith", 7709987654, "picturepicturepicture", "videovideovideovideo", 2),
  ("biographybiographybiographybiographybiographybiography", "billy", "smith", 7709987654, "picturepicturepicture", "videovideovideovideo", 3),
  ("biographybiographybiographybiographybiographybiography", "billy", "smith", 7709987654, "picturepicturepicture", "videovideovideovideo", 4),
  ("biographybiographybiographybiographybiographybiography", "billy", "smith", 7709987654, "picturepicturepicture", "videovideovideovideo", 5),
  ("biographybiographybiographybiographybiographybiography", "billy", "smith", 7709987654, "picturepicturepicture", "videovideovideovideo", 6),
  ("biographybiographybiographybiographybiographybiography", "billy", "smith", 7709987654, "picturepicturepicture", "videovideovideovideo", 7),
  ("biographybiographybiographybiographybiographybiography", "billy", "smith", 7709987654, "picturepicturepicture", "videovideovideovideo", 8),
  ("biographybiographybiographybiographybiographybiography", "billy", "smith", 7709987654, "picturepicturepicture", "videovideovideovideo", 9);


INSERT INTO education(focus, graduation_date, name)
VALUES ("focusfocusfocusfocusfocusfocus", "YYYY-MM-DD HH:MI:SS", "University of Georgia"),
  ("focusfocusfocusfocusfocusfocus", "YYYY-MM-DD HH:MI:SS", "University of Hawaii"),
  ("focusfocusfocusfocusfocusfocus", "YYYY-MM-DD HH:MI:SS", "University of Florida"),
  ("focusfocusfocusfocusfocusfocus", "YYYY-MM-DD HH:MI:SS", "University of Alabama"),
  ("focusfocusfocusfocusfocusfocus", "YYYY-MM-DD HH:MI:SS", "University of Tennessee"),
  ("focusfocusfocusfocusfocusfocus", "YYYY-MM-DD HH:MI:SS", "University of Arkansas"),
  ("focusfocusfocusfocusfocusfocus", "YYYY-MM-DD HH:MI:SS", "Harvard"),
  ("focusfocusfocusfocusfocusfocus", "YYYY-MM-DD HH:MI:SS", "Princeton"),
  ("focusfocusfocusfocusfocusfocus", "YYYY-MM-DD HH:MI:SS", "Yale");

INSERT INTO job_history(endDate, location, reasonLeft, startDate, title)
VALUES ("YYYY-MM-DD HH:MI:SS", "Atlanta", "fired", "YYYY-MM-DD HH:MI:SS", "line cook"),
  ("YYYY-MM-DD HH:MI:SS", "Sacramento", "quit", "YYYY-MM-DD HH:MI:SS", "sous chef"),
  ("YYYY-MM-DD HH:MI:SS", "Atlanta", "left for better opportunities", "YYYY-MM-DD HH:MI:SS", "executive chef"),
  ("YYYY-MM-DD HH:MI:SS", "Birmingham", "fired", "YYYY-MM-DD HH:MI:SS", "line cook"),
  ("YYYY-MM-DD HH:MI:SS", "Birmingham", "fired", "YYYY-MM-DD HH:MI:SS", "line cook"),
  ("YYYY-MM-DD HH:MI:SS", "Birmingham", "fired", "YYYY-MM-DD HH:MI:SS", "line cook"),
  ("YYYY-MM-DD HH:MI:SS", "Jacksonville", "fired", "YYYY-MM-DD HH:MI:SS", "line cook"),
  ("YYYY-MM-DD HH:MI:SS", "Jacksonville", "fired", "YYYY-MM-DD HH:MI:SS", "line cook"),
  ("YYYY-MM-DD HH:MI:SS", "Jacksonville", "fired", "YYYY-MM-DD HH:MI:SS", "line cook");

INSERT INTO job_listings(description, pay, title)
VALUES ("this is a job and its really cool and pays a ton!", "56,000/yr", "Executive Chef"),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Executive Chef"),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Executive Chef"),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Executive Chef"),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Executive Chef"),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Executive Chef"),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Executive Chef"),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Executive Chef");

INSERT INTO rest_profile(about, location, phone, picture, name, video, user_id)
VALUES ("aboutaboutaboutabout", "San Antonio", 5555555555, "picturepicturepicturepicture", "little italy", "videovideovideovideo", 1),
  ("aboutaboutaboutabout", "San Antonio", 5555555555, "picturepicturepicturepicture", "little italy", "videovideovideovideo", 2),
  ("aboutaboutaboutabout", "San Antonio", 5555555555, "picturepicturepicturepicture", "little italy", "videovideovideovideo", 3),
  ("aboutaboutaboutabout", "San Antonio", 5555555555, "picturepicturepicturepicture", "little italy", "videovideovideovideo", 4),
  ("aboutaboutaboutabout", "San Antonio", 5555555555, "picturepicturepicturepicture", "little italy", "videovideovideovideo", 5),
  ("aboutaboutaboutabout", "San Antonio", 5555555555, "picturepicturepicturepicture", "little italy", "videovideovideovideo", 6),
  ("aboutaboutaboutabout", "San Antonio", 5555555555, "picturepicturepicturepicture", "little italy", "videovideovideovideo", 7),
  ("aboutaboutaboutabout", "San Antonio", 5555555555, "picturepicturepicturepicture", "little italy", "videovideovideovideo", 8),
  ("aboutaboutaboutabout", "San Antonio", 5555555555, "picturepicturepicturepicture", "little italy", "videovideovideovideo", 9);



INSERT INTO user_skills(picture, video)
VALUES ("picturepicturepicture", "videovideovideo"),
  ("picturepicturepicture", "videovideovideo"),
("picturepicturepicture", "videovideovideo"),
("picturepicturepicture", "videovideovideo"),
("picturepicturepicture", "videovideovideo"),
("picturepicturepicture", "videovideovideo"),
("picturepicturepicture", "videovideovideo"),
("picturepicturepicture", "videovideovideo"),
("picturepicturepicture", "videovideovideo");




