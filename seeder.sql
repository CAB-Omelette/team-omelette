USE omelette_db;


INSERT INTO chef_profile(bio, first_name, last_name, phone, picture, user_id)
    VALUES ("Classically trained chef looking for work in the San Antonio area", "Chris", "Davis", "210-908-0718", "https://i.imgur.com/Lk4Awmf.png", 2),
      ("Clasically trained chef looking for work in the San Antonio area", "Ben", "Johnson", "210-908-0718", "https://i.imgur.com/Lk4Awmf.png", 3),
      ("Clasically trained chef looking for work in the San Antonio area", "Alex", "Jameson", "210-908-0718", "https://i.imgur.com/Lk4Awmf.png", 4),
      ("Clasically trained chef looking for work in the San Antonio area", "James", "Dean", "210-908-0718", "https://i.imgur.com/Lk4Awmf.png", 5),
      ("Clasically trained chef looking for work in the San Antonio area", "Rudy", "Max", "210-908-0718", "https://i.imgur.com/Lk4Awmf.png", 6),
      ("Clasically trained chef looking for work in the San Antonio area", "Michelle", "Tueme", "210-908-0718", "https://i.imgur.com/Lk4Awmf.png", 7),
      ("Clasically trained chef looking for work in the San Antonio area", "David", "Glidden", "210-908-0718", "https://i.imgur.com/Lk4Awmf.png", 8),
      ("Clasically trained chef looking for work in the San Antonio area", "Jen", "Connor", "210-908-0718", "https://i.imgur.com/Lk4Awmf.png", 9),
      ("Clasically trained chef looking for work in the San Antonio area", "Ryan", "Blake", "210-908-0718", "https://i.imgur.com/Lk4Awmf.png", 10);


INSERT INTO rest_profile(about, city, name, phone, picture, state, street, zip, user_id)
    VALUES ("Worst bbq in texas. It's al about the sauce", "san antonio", "Rudys bbq", "210-918-0716", "https://i.imgur.com/Lk4Awmf.png", "tx", "15560 North Interstate Highway 35","78154", 11),
      ("The international house of pancakes!", "san antonio", "ihop", "210-918-0716", "https://i.imgur.com/Lk4Awmf.png", "tx", "15560 North Interstate Highway 35","78154", 12),
      ("Chic eatery on the water. Specializing in seafood", "fort myers", "Cru", "239-918-0716", "https://i.imgur.com/Lk4Awmf.png", "fl", "13499 S Cleveland Ave","33907", 13),
      ("Upscale eatery and bar.", "san antonio", "Blackstar", "210-918-0716", "https://i.imgur.com/Lk4Awmf.png", "tx", "15560 North Interstate Highway 35","78154", 14),
      ("Relaxed bar and coffee shop. Happy hour every day from 4-7", "san antonio", "Rosella", "210-918-0716", "https://i.imgur.com/Lk4Awmf.png", "tx", "15560 North Interstate Highway 35","78154", 15),
      ("The longest bar in Texas. Old school interior with great cocktails", "san antonio", "Esquire Tavern", "210-918-0716", "https://i.imgur.com/Lk4Awmf.png", "tx", "15560 North Interstate Highway 35","78154", 16),
      ("Gourmet burgers and craft beer with a great outdoor patio", "san antonio", "Market on Houston", "210-918-0716", "https://i.imgur.com/Lk4Awmf.png", "tx", "15560 North Interstate Highway 35","78154", 17),
      ("Best burgers in Paris, with an American twist", "Paris", "Big Fernand", "210-918-0716", "https://i.imgur.com/Lk4Awmf.png", "", "55 Rue du Faubourg Poissonnière","", 18),
      ("Homemade Italian food like grandma used to make", "san antonio", "Italia", "210-918-0716", "https://i.imgur.com/Lk4Awmf.png", "tx", "15560 North Interstate Highway 35","78154", 19),
      ("Custom pizzas and pasta in an upscale setting", "san antonio", "Zoes", "210-918-0716", "https://i.imgur.com/Lk4Awmf.png", "tx", "15560 North Interstate Highway 35","78154", 20);




INSERT INTO education(focus, graduation_date, name, user_id)
    VALUES("Culinary arts", "02/15/1999", "Culinary Institute Of America", 1),
      ("Culinary arts", "02/15/1999", "Culinary Institute Of America", 2),
      ("Culinary arts", "02/15/1999", "Culinary Institute Of America", 3),
      ("Culinary arts", "02/15/1999", "Culinary Institute Of America", 4),
      ("Culinary arts", "02/15/1999", "Culinary Institute Of America", 5),
      ("Culinary arts", "02/15/1999", "Culinary Institute Of America", 6),
      ("Culinary arts", "02/15/1999", "Culinary Institute Of America", 7),
      ("Culinary arts", "02/15/1999", "Culinary Institute Of America", 8),
      ("Culinary arts", "02/15/1999", "Culinary Institute Of America", 9),
      ("Culinary arts", "02/15/1999", "Culinary Institute Of America", 10);



INSERT INTO job_history(end_date, location, reason_left, start_date, title, user_id)
VALUES ("01/15/2008", "Chilis", "quit", "01/01/2006", "line cook", 1),
  ("01/15/2008", "Chilis", "quit", "01/01/2006", "line cook", 2),
  ("01/15/2008", "Chilis", "quit", "01/01/2006", "line cook", 3),
  ("01/15/2008", "Cru", "quit", "01/01/2006", "line cook", 4),
  ("01/15/2008", "Chilis", "quit", "01/01/2006", "line cook", 5),
  ("01/15/2008", "Esquire", "quit", "01/01/2006", "line cook", 6),
  ("01/15/2008", "Chilis", "quit", "01/01/2006", "line cook", 7),
  ("01/15/2008", "Olive Garden", "quit", "01/01/2006", "line cook", 8),
  ("01/15/2008", "Chilis", "quit", "01/01/2006", "line cook", 9),
  ("01/15/2008", "Chilis", "quit", "01/01/2006", "line cook", 10),
  ("01/15/2008", "Olive Garden", "quit", "01/01/2006", "line cook", 1),
  ("01/15/2008", "Cru", "quit", "01/01/2006", "line cook", 2),
  ("01/15/2008", "Blackstar", "quit", "01/01/2006", "line cook", 3),
  ("01/15/2008", "Rudys", "quit", "01/01/2006", "line cook", 4),
  ("01/15/2008", "ihop", "quit", "01/01/2006", "line cook", 5),
  ("01/15/2008", "Dennys", "quit", "01/01/2006", "line cook", 6),
  ("01/15/2008", "Zoes", "quit", "01/01/2006", "line cook", 7),
  ("01/15/2008", "Italia", "quit", "01/01/2006", "line cook", 8),
  ("01/15/2008", "Big Fernand", "quit", "01/01/2006", "line cook", 9),
  ("01/15/2008", "Rosella", "quit", "01/01/2006", "line cook", 10);

INSERT INTO job_listings(description, pay, title, user_id)
VALUES ("this is a job and its really cool and pays a ton!", "56,000/yr", "Executive Chef", 11),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Line Cook", 12),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Sous Chef", 13),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Executive Chef", 14),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Line Cook", 15),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Sous Chef", 16),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Pit Master", 17),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Executive Chef", 18),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Executive Chef", 19),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Line Cook", 20),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Sous Chef", 12),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Executive Chef", 14),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Line Cook", 11),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Sous Chef", 11),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Pit Master", 11),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Executive Chef", 19),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Executive Chef", 15),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Line Cook", 20),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Sous Chef", 16),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Executive Chef", 13),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Line Cook", 12),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Sous Chef", 10),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Pit Master", 20),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Executive Chef", 18),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Executive Chef", 17),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Line Cook", 14),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Sous Chef", 15),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Executive Chef", 16),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Line Cook", 18),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Sous Chef", 17),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Pit Master", 12),
  ("this is a job and its really cool and pays a ton!", "56,000/yr", "Executive Chef", 12);







