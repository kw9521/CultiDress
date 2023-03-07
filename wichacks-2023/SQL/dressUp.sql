DROP DATABASE IF EXISTS dressUp;

CREATE DATABASE dressUp;
USE dressUp;

-- CHARACTER & CLOTHING TABLES
DROP TABLE IF EXISTS newCharacter;
CREATE TABLE newCharacter(
    characterID INT(7) NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    catchphrase VARCHAR(45) NULL,
    PRIMARY KEY (characterID)
);

DROP TABLE IF EXISTS categories;
CREATE TABLE categories(
    categoryID INT(2) NOT NULL,
    categoryName VARCHAR(30) NOT NULL,
    PRIMARY KEY (categoryID)
);

INSERT INTO categories VALUES (01, "Hair"), (02, "Tops"), (03, "Bottoms"), (04, "Shoes"), (05, "Cultural");

DROP TABLE IF EXISTS clothingItem;
CREATE TABLE clothingItem(
    clothingID INT(5) NOT NULL,
    categoryID INT(2) NOT NULL,
    name VARCHAR(45) NOT NULL,
    link VARCHAR(100) NOT NULL,
    PRIMARY KEY (clothingID, categoryID),
    CONSTRAINT category_clothingItem_fk FOREIGN KEY (categoryID) REFERENCES categories (categoryID)
);

-- ClothingID guide
    -- Starts with 1: Hair
    -- Starts with 2: Tops
    -- Starts with 3: Bottoms
    -- Starts with 4: Shoes
    -- Starts with 5: Cultural Clothing
INSERT INTO clothingItem VALUES (10000, 01, "Low Bun", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Hair\\Low_Bun.png"),
(20000, 02, "Cropped Long Sleeve Crewneck", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\CrewNeck_LongSleeve_Cropped.png"),
(20001, 02, "Long Sleeve Crewneck", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\CrewNeck_LongSleeve.png"),
(20002, 02, "Cropped Short Sleeve Crewneck", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\CrewNeck_ShortSleeve_Cropped.png"),
(20003, 02, "Short Sleeve Crewneck", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\CrewNeck_ShortSleeve.png"),
(20004, 02, "Cropped Sleeveless Crewneck", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\CrewNeck_Sleeveless_Cropped.png"),
(20005, 02, "Sleeveless Crewneck", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\CrewNeck_Sleeveless.png"),
(20006, 02, "Cropped Long Sleeve Turtleneck", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\TurtleNeck_LongSleeve_Cropped.png"),
(20007, 02, "Long Sleeve Turtleneck", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\TurtleNeck_LongSleeve.png"),
(20008, 02, "Cropped Short Sleeve Turtleneck", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\TurtleNeck_ShortSleeve_Cropped.png"),
(20009, 02, "Short Sleeve Turtleneck", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\TurtleNeck_ShortSleeve.png"),
(20010, 02, "Cropped Sleeveless Turtleneck", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\TurtleNeck_Sleeveless_Cropped.png"),
(20011, 02, "Sleeveless Turtleneck", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\TurtleNeck_Sleeveless.png"),
(20012, 02, "Cropped Long Sleeve V-Neck", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\VNeck_LongSleeve_Cropped.png"),
(20013, 02, "Long Sleeve V-Neck", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\VNeck_LongSleeve.png"),
(20014, 02, "Cropped Short Sleeve V-Neck", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\VNeck_ShortSleeve_Cropped.png"),
(20015, 02, "Short Sleeve V-Neck", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\VNeck_ShortSleeve.png"),
(20016, 02, "Cropped Sleeveless V-Neck", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\VNeck_Sleeveless_Cropped.png"),
(20017, 02, "Sleeveless V-Neck", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\VNeck_Sleeveless.png"),
(30000, 03, "Baggy Pants", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Pants\\Pants_Baggy.png"),
(30001, 03, "Flared Pants", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Pants\\Pants_Flared.png"),
(30002, 03, "Skinny Pants", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Pants\\Pants_Skinny.png"),
(30003, 03, "Straight Pants", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Pants\\Pants_Straight.png"),
(30004, 03, "Shorts Long", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Pants\\Shorts_Shin.png"),
(30005, 03, "Shorts Medium", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Pants\\Shorts_Thigh.png"),
(30006, 03, "Shorts Long", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Pants\\Shorts_short.png"),
(40000, 04, "Flats", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Shoes\\Flats.png"),
(50000, 05, "Hanfu", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\CulturalClothing\\Hanfu.png"),
(50001, 05, "Iro ati Buba", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\CulturalClothing\\IroAtiBuba.png"),
(50002, 05, "Jeogori", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\CulturalClothing\\Jeogori.png"),
(50003, 05, "Thobe", "file:demo\\src\\main\\java\\com\\example\\IMAGES\\CulturalClothing\\Thobe.png");

-- Did not get to implement
--
-- DROP TABLE IF EXISTS keywords;
-- CREATE TABLE keywords(
--     keywordID INT(2) NOT NULL,
--     keyword VARCHAR(30) NOT NULL,
--     PRIMARY KEY (keywordID)
-- );

-- DROP TABLE IF EXISTS clothingKeywords;
-- CREATE TABLE clothingKeywords(
--     clothingID INT(5) NOT NULL,
--     keywordID INT(2) NOT NULL,
--     PRIMARY KEY (clothingID, keywordID),
--     CONSTRAINT clothingItem_clothingKeywords_fk FOREIGN KEY (clothingID) REFERENCES clothingItem (clothingID),
--     CONSTRAINT keywords_clothingKeywords_fk FOREIGN KEY (keywordID) REFERENCES keywords (keywordID)
-- );

DROP TABLE IF EXISTS characterClothing;
CREATE TABLE characterClothing(
    characterID INT(7) NOT NULL,
    clothingID INT(5) NOT NULL,
    PRIMARY KEY (characterID, clothingID),
    CONSTRAINT character_characterClothing_fk FOREIGN KEY (characterID) REFERENCES newCharacter (characterID),
    CONSTRAINT clothingItems_characterClothing_fk FOREIGN KEY (clothingID) REFERENCES clothingItem (clothingID)
);


-- USER TABLES
DROP TABLE IF EXISTS userInfo;
CREATE TABLE userInfo(
    userID INT(5) NOT NULL AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL,
    country VARCHAR(45) NULL,
    PRIMARY KEY (userID)
);

DROP TABLE IF EXISTS userCharacters;
CREATE TABLE userCharacters(
    userID INT(5) NOT NULL,
    characterID INT(5),
    PRIMARY KEY (userID, characterID),
    CONSTRAINT userInfo_userCharacters_fk FOREIGN KEY (userID) REFERENCES userInfo (userID),
    CONSTRAINT character_userCharacters_fk FOREIGN KEY (characterID) REFERENCES newCharacter (characterID)
);