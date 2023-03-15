CREATE DATABASE Gamez

DROP TABLE products

CREATE TABLE products (
	product_id int primary key,
	product_name nvarchar(50),
	product_publisher nvarchar (50),
	product_category nvarchar(40),
	product_description nvarchar(1000),
	price int,
	product_images text,
)

INSERT INTO products (product_id,product_name,product_publisher,product_category,product_description,price,product_images)

VALUES

(001,'Son Of The Forest','New Night','Multiplayer','Sent to find a missing billionaire on a remote island, you find yourself in a cannibal-infested hellscape. Craft, build, and struggle to survive, alone or with friends, in this terrifying new open-world survival horror simulator.',385000,'/images/game/son_of_the_forest.jpg'),

(002,'Hogwarts Legacy','Warner Bros Games','Single play','Hogwarts Legacy is an immersive, open-world action RPG. Now you can take control of the action and be at the center of your own adventure in the wizarding world.',990000,'/images/game/hogwart_legacy.jpg'),

(003,'Wo Long: Fallen Dynasty','KOEI TECMO GAMES','RPG','A new dark fantasy Three Kingdoms action RPG from Team NINJA, the developers of Nioh.',990000,'/images/game/wo_long.jpg'),

(004,'Atomic Heart','Focus Entertainment','FPS','In a mad and sublime utopian world, take part in explosive encounters. Adapt your fighting style to each opponent, use your environment and upgrade your equipment to fulfill your mission. If you want to reach the truth, youll have to pay in blood.',750000,'/images/game/atomic_heart.jpg'),

(005,'Stardew Valley','ConcernedApe','Farming Sim','Youve inherited your grandfathers old farm plot in Stardew Valley. Armed with hand-me-down tools and a few coins, you set out to begin your new life. Can you learn to live off the land and turn these overgrown fields into a thriving home?',165000,'/images/game/stardew_valley.jpg'),

(006,'Company of Heroes 3','SEGA','Strategy','Bigger and better than ever, Company of Heroes 3 combines heart-pounding combat with deeper strategic choices in a stunning Mediterranean theatre of war. In Company of Heroes 3, every battle tells a story...whats yours?',1000000,'/images/game/coh3.jpg'),

(007,'Kerbal Space Program 2','Priavte Division','Simulation','Kerbal Space Program 2 is the sequel to the acclaimed space-flight simulation game Kerbal Space Program. Enter the next generation of space adventure with exciting new parts, stunning visuals, fully revamped UI and Map View, and rich new environments to explore.',830000,'/images/game/kerbal_space_program_2.jpg'),

(008,'Destiny 2: Lightfall','Bungie','Adventure','Destiny 2 is an action MMO with a single evolving world that you and your friends can join anytime, anywhere, absolutely free.',1499000,'/images/game/destiny_2.jpg'),

(009,'OCTOPATH TRAVELER II','Square Enix','RPG','This game is a brand-new entry in the OCTOPATH TRAVELER series, the first installment of which was initially released in 2018 and sold over 3 million copies worldwide.',165000,'/images/game/octopath_traveler_2.jpg'),

(010,'EA SPORTS™ FIFA 23','Electronic Arts','Sports','FIFA 23 brings The World’s Game to the pitch, with HyperMotion2 Technology, men’s and women’s FIFA World Cup™coming during the season, women’s club teams, cross-play features*, and more.',1090000,'/images/game/fifa23.jpg'),

(011,'The Last of Us™ Part I','PlayStation PC LLC','Adventure','Experience the emotional storytelling and unforgettable characters in The Last of Us™, winner of over 200 Game of the Year awards.',1399000,'/images/game/the_last_of_us_1.jpg'),

(012,'Borderlands 3','2K','RPG','The original shooter-looter returns, packing bazillions of guns and a mayhem-fueled adventure! Blast through new worlds and enemies as one of four new Vault Hunters.',165000,'/images/game/borderlands_3.jpg'),

(013,'The Elder Scrolls® Online','Bethesda Softworks','RPG','Winner of more than 200 Game of the Year Awards, Skyrim Special Edition brings the epic fantasy to life in stunning detail. The Special Edition includes the critically acclaimed game and add-ons with all-new features like remastered art and effects, volumetric god rays, dynamic depth of field, screen-space reflections, and more.',450000,'/images/game/TES_online.jpg'),

(014,'Euro Truck Simulator 2','SCS Software','Simulation','Travel across Europe as king of the road, a trucker who delivers important cargo across impressive distances! With dozens of cities to explore, your endurance, skill and speed will all be pushed to their limits.',87000,'/images/game/euro_truck_simulator_2.jpg'),

(015,'ELDEN RING','FromSoftware Inc.','RPG','THE NEW FANTASY ACTION RPG. Rise, Tarnished, and be guided by grace to brandish the power of the Elden Ring and become an Elden Lord in the Lands Between.',898000,'/images/game/elden_ring.jpg'),

(016,'NBA 2K23','2K','Sports','Rise to the occasion in NBA 2K23. Showcase your talent in MyCAREER. Pair All-Stars with timeless legends in MyTEAM. Build your own dynasty in MyGM, or guide the NBA in a new direction with MyLEAGUE. Take on NBA or WNBA teams in PLAY NOW and feel true-to-life gameplay.',300000,'/images/game/nba_2k23.jpg'),

(017,'WILD HEARTS™','Electronic Arts','Multiplayer','Master ancient tech to hunt down giant beasts.',1090000,'/images/game/wild_hearts.jpg'),

(018,'NARAKA: BLADEPOINT','NetEase','Battle royal','NARAKA: BLADEPOINT is an up to 60-player PVP mythical action combat experience with martial arts inspired melee combat, gravity defying mobility, vast arsenals of melee & ranged weapons, legendary customizable heroes with epic abilities - inspired by the legends of the Far East.',360000,'/images/game/naraka.jpg'),

(019,'Baldurs Gate 3','Larian Studios','RPG','Gather your party, and return to the Forgotten Realms in a tale of fellowship and betrayal, sacrifice and survival, and the lure of absolute power.',990000,'/images/game/baldurs_gate_3.jpg'),

(020,'The Forest','Endnight Games Ltd','Open World','Open World Survival Craft
As the lone survivor of a passenger jet crash, you find yourself in a mysterious forest battling to stay alive against a society of cannibalistic mutants. Build, explore, survive in this terrifying first person survival horror simulator.',188000,'/images/game/the_forest.jpg'),

(021,'Project Zomboid','The Indie Stone','Multipalyers','Project Zomboid is the ultimate in zombie survival. Alone or in MP: you loot, build, craft, fight, farm and fish in a struggle to survive. A hardcore RPG skillset, a vast map, massively customisable sandbox and a cute tutorial raccoon await the unwary. So how will you die? All it takes is a bite.',188000,'/images/game/project_zomboid.jpg'),

(022,'Resident Evil 4','CAPCOM Co., Ltd.','Survival Horror','Survival is just the beginning. Six years have passed since the biological disaster in Raccoon City. Leon S. Kennedy, one of the survivors, tracks the presidents kidnapped daughter to a secluded European village, where there is something terribly wrong with the locals.',1322000,'/images/game/re4.jpg'),

(023,'Dead by Daylight','Behaviour Interactive Inc.','Online Co-Op','Dead by Daylight is a multiplayer (4vs1) horror game where one player takes on the role of the savage Killer, and the other four players play as Survivors, trying to escape the Killer and avoid being caught and killed.',220000,'/images/game/dead_by_daylight.jpg'),

(024,'Wallpaper Engine','Wallpaper Engine Team','Software','Use stunning live wallpapers on your desktop. Animate your own images to create new wallpapers or import videos/websites and share them on the Steam Workshop!',70000,'/images/game/wallpaper_engine.jpg'),

(025,'Cult of the Lamb','Devolver Digital','Base Building','Start your own cult in a land of false prophets, venturing out into diverse and mysterious regions to build a loyal community of woodland Followers and spread your Word to become the one true cult.',300000,'/images/game/cult_of_the_lamb.jpg'),

(026,'Dying Light','Techland','Survival Horror','First-person action survival game set in a post-apocalyptic open world overrun by flesh-hungry zombies. Roam a city devastated by a mysterious virus epidemic. Scavenge for supplies, craft weapons, and face hordes of the infected.',108000,'/images/game/dying_light.jpg'),

(027,'No Mans Sky','Hello Games','Open World','No Mans Sky is a game about exploration and survival in an infinite procedurally generated universe.',352000,'/images/game/no_mans_sky.jpg'),

(028,'Atelier Ryza: Ever Darkness & the Secret Hideout','KOEI TECMO GAMES CO.','JRPG','This story takes place three years after the events of the previous game “Atelier Ryza: Ever Darkness & the Secret Hideout,” and depicts the reunion of Ryza and her friends, who go through new encounters and goodbyes to discover a true priceless treasure.',240000,'/images/game/atelier_ryza.jpg'),

(029,'Atelier Ryza 2: Lost Legends & the Secret Fairy','KOEI TECMO GAMES CO.','JRPG','This story takes place three years after the events of the previous game “Atelier Ryza: Ever Darkness & the Secret Hideout,” and depicts the reunion of Ryza and her friends, who go through new encounters and goodbyes to discover a true priceless treasure.',240000,'/images/game/atelier_ryza_2.jpg'),

(030,'Black Desert','Pearl Abyss','MMORPG','Played by over 20 million Adventurers - Black Desert Online is an open-world, action MMORPG. Experience intense, action-packed combat, battle massive world bosses, fight alongside friends to siege and conquer castles, and train in professions such as fishing, trading, crafting, cooking, and more!',80000,'/images/game/black_desert.jpg'),

(031,'Cities: Skylines','Paradox Interactive','City Builder','Cities: Skylines is a modern take on the classic city simulation. The game introduces new game play elements to realize the thrill and hardships of creating and maintaining a real city whilst expanding on some well-established tropes of the city building experience.',325000,'/images/game/cities_skylines.jpg'),

(032,'Noita','Nolla Games','Roguelike','Noita is a magical action roguelite set in a world where every pixel is physically simulated. Fight, explore, melt, burn, freeze and evaporate your way through the procedurally generated world using spells youve created yourself.',194000,'/images/game/noita.jpg'),

(033,'Stray','Annapurna Interactive','Adventure','Lost, alone and separated from family, a stray cat must untangle an ancient mystery to escape a long-forgotten cybercity and find their way home.',255000,'/images/game/stray.jpg'),

(034,'Sea of Thieves','Xbox Game Studios','Open World','Sea of Thieves offers the essential pirate experience, from sailing and fighting to exploring and looting – everything you need to live the pirate life and become a legend in your own right. With no set roles, you have complete freedom to approach the world, and other players, however you choose.',310000,'/images/game/sea_of_thieves.jpg'),

(035,'Raft','Axolot Games','Open World Survival Craft','Raft throws you and your friends into an epic oceanic adventure! Alone or together, players battle to survive a perilous voyage across a vast sea! Gather debris, scavenge reefs and build your own floating home, but be wary of the man-eating sharks!',188000,'/images/game/raft.jpg'),

(036,'Dead Space','Electronic Arts','Third-Person Shooter','The sci-fi survival-horror classic returns, completely rebuilt to offer an even more immersive experience — including visual, audio, and gameplay improvements — while staying faithful to the original game’s thrilling vision.',990000,'/images/game/dead_space.jpg'),

(037,'theHunter: Call of the Wild™','Expansive Worlds','Open World','Experience an atmospheric hunting game like no other in this realistic and visually breathtaking open world. Immerse yourself in the atmospheric single player campaign, or share the ultimate hunting experience with friends.',75000,'/images/game/theHunter.jpg'),

(038,'Pizza Tower','Tour De Pizza','Indie','Pizza Tower is a fast paced 2D platformer inspired by the Wario Land series, with an emphasis on movement, exploration and score attack. Featuring highly stylized pixel art inspired by the cartoons from the 90s, and a highly energetic soundtrack.',260000,'/images/game/pizza_tower.jpg'),

(039,'Phasmophobia','Kinetic Games','Online Co-Op','Phasmophobia is a 4 player online co-op psychological horror. Paranormal activity is on the rise and it’s up to you and your team to use all the ghost-hunting equipment at your disposal in order to gather as much evidence as you can.',160000,'/images/game/phasmophobia.jpg'),

(040,'MONSTER HUNTER RISE','CAPCOM Co., Ltd','RPG','Rise to the challenge and join the hunt! In Monster Hunter Rise, the latest installment in the award-winning and top-selling Monster Hunter series, you’ll become a hunter, explore brand new maps and use a variety of weapons to take down fearsome monsters as part of an all-new storyline.',881000,'/images/game/monster_hunter_rise.jpg')