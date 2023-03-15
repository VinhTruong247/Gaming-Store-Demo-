USE [Gamez]
GO
create table images (id int, name varchar(max), img varbinary(max))
select * from images

INSERT INTO dbo.images(id,name,img )
values
('1','Atelier Ryza: Ever Darkness & the Secret Hideout',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\atelierryza.jpg', SINGLE_BLOB) as T1)),
('2','Atelier Ryza 2: Lost Legends & the Secret Fairy',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\atelierryza2.jpg', SINGLE_BLOB) as T1)),
('3','Atomic Heart',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\atomicheart.jpg', SINGLE_BLOB) as T1)),
('4','Baldurs Gate 3',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\baldursgate3.jpg', SINGLE_BLOB) as T1)),
('5','Black Desert',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\blackdesert.jpg', SINGLE_BLOB) as T1)),
('6','Borderlands 3',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\borderlands3.jpg', SINGLE_BLOB) as T1)),
('7','Cities: Skylines',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\citiesskylines.jpg', SINGLE_BLOB) as T1)),
('8','Company of Heroes 3',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\companyofheroes3.jpg', SINGLE_BLOB) as T1)),
('9','Cult of the Lamb',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\cultofthelamb.jpg', SINGLE_BLOB) as T1)),
('10','Dead by Daylight',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\deadbydaylight.jpg', SINGLE_BLOB) as T1)),
('11','Dead Space',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\deadspace.jpg', SINGLE_BLOB) as T1)),
('12','Destiny 2: Lightfall',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\destiny2.jpg', SINGLE_BLOB) as T1)),
('13','Dying Light',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\dyinglight.jpg', SINGLE_BLOB) as T1)),
('14','ELDEN RING',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\eldenring.jpg', SINGLE_BLOB) as T1)),
('15','Euro Truck Simulator 2',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\eurotruck.jpg', SINGLE_BLOB) as T1)),
('16','EA SPORTS� FIFA 23',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\fifa23.jpg', SINGLE_BLOB) as T1)),
('17','Hogwarts Legacy',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\hogwartlegacy.jpg', SINGLE_BLOB) as T1)),
('18','Kerbal Space Program 2',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\kerbalspaceprogram2.jpg', SINGLE_BLOB) as T1)),
('19','MONSTER HUNTER RISE',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\monsterhunterrise.jpg', SINGLE_BLOB) as T1)),
('20','NARAKA: BLADEPOINT',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\naraka.jpg', SINGLE_BLOB) as T1)),
('21','NBA 2K23',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\nba2k23.jpg', SINGLE_BLOB) as T1)),
('22','No Mans Sky',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\nomansky.jpg', SINGLE_BLOB) as T1)),
('23','Noita',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\noita.jpg', SINGLE_BLOB) as T1)),
('24','OCTOPATH TRAVELER II',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\octopathtraveler2.jpg', SINGLE_BLOB) as T1)),
('25','Phasmophobia',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\phasmophobia.jpg', SINGLE_BLOB) as T1)),
('26','Pizza Tower',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\pizzatower.jpg', SINGLE_BLOB) as T1)),
('27','Project Zomboid',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\projectzomboid.jpg', SINGLE_BLOB) as T1)),
('28','Raft',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\raft.jpg', SINGLE_BLOB) as T1)),
('29','Resident Evil 4',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\residentevil4.jpg', SINGLE_BLOB) as T1)),
('30','Sea of Thieves',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\seaofthieves.jpg', SINGLE_BLOB) as T1)),
('31','Son Of The Forest',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\sonoftheforest.jpg', SINGLE_BLOB) as T1)),
('32','Stardew Valley',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\stardewvalley.jpg', SINGLE_BLOB) as T1)),
('33','Stray',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\stray.jpg', SINGLE_BLOB) as T1)),
('34','The Elder Scrolls� Online',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\theelderscrolls.jpg', SINGLE_BLOB) as T1)),
('35','The Forest',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\theforest.jpg', SINGLE_BLOB) as T1)),
('36','theHunter: Call of the Wild�',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\thehunter.jpg', SINGLE_BLOB) as T1)),
('37','The Last of Us� Part I',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\thelastofus.jpg', SINGLE_BLOB) as T1)),
('38','Wallpaper Engine',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\wallpaperengine.jpg', SINGLE_BLOB) as T1)),
('39','WILD HEARTS�',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\wildheart.jpg', SINGLE_BLOB) as T1)),
('40','Wo Long: Fallen Dynasty',(SELECT * FROM OPENROWSET(BULK N'D:\STUDY FILES\PRJ301\Gaming-Store-Demo--main\GamePic\wolong.jpg', SINGLE_BLOB) as T1))