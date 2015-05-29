package com.battlenex.game;

public class Censor {
	
	private static final char[][] badwordCharacters;
	private static final char[][] domainCharacters;

	static {
		
		/**
		 * Domain names.
		 */
		String[] domainNames = new String[]{ "123india", "20m", "2bmail", "2ndmail", "2ya", "4a2z", "4anything", "5star", "abercrombie", "acmecity", "acmemail", "acont", "advalvas", "alloymail", "altavista", "altern", "amexmail", "amuro", "anarchyonline", "angelfire", "animalhouse", "animenation", "aol", "apexmail", "apmail", "aristotle", "asean-mail", "asheronscall", "asianoffice", "asiansonly", "asianwired", "atozasia", "autonr", "avidgamers", "aw-online", "axoskate", "bannertown", "basemail", "bboy", "beijingoffice", "bellsouth", "berlinoffice", "bigfoot", "bimamail", "birdmail", "bl", "bla-bla", "blueyonder", "bombdiggity", "bostonoffice", "bovinelabs", "bravenet", "brinkster", "businessweekmail", "bustamail", "buyersusa", "callsign", "caramail", "care2", "careerbuildermail", "casablancaresort", "ccnmail", "certifiedmail", "chickmail", "chipmail", "christianmail", "city2city", "cmpnetmail", "coldmail", "collegebeat", "collegeclub", "collegemail", "comicmail", "communityconnect", "comprendemail", "conok", "coollist", "countrycool", "crobos", "cwebmail", "cybercafemaui", "cybergrrl", "d4mail", "dallasoffice", "daoc", "daru", "dbzmail", "dcemail", "dcoffices", "dejanews", "deneg", "depechemodemail", "deseretmail", "digitalmail", "digitalmusicnation", "directbox", "doramail", "dottk", "dragonempires", "dwp", "dynamitemail", "e247", "earthonline", "easyspace", "ebay", "ecompare", "edmail", "edtn", "educastmail", "ekidz", "email-london", "emailchoice", "emailit", "emailvista", "emaster", "entrepreneurmag", "etoast", "etrade", "eudoramail", "everquest", "evilcowgod", "expage", "ezboard", "ezzemail", "fancemail", "fastermail", "fastmail", "feierabend", "fetchmail", "fiberia", "filetap", "finfin", "firstcampus", "flairmail", "flashemail", "flashmail", "floydmail", "fnmail", "fortunecity", "france-mail", "free-org", "freeaccount", "freebox", "freemail", "freestamp", "freewebemail", "fresnomail", "funurl", "gamespotmail", "gee-wiz", "geecities", "geocities", "geocitys", "getmailfree", "gh2000", "gigileung", "glay", "glossy", "gmx", "gmxattachments", "gnwmail", "grabasite", "grreat", "gtemail", "gurlmail", "hanmail", "hdvest", "headbone", "helbreath", "hellbreath", "hempseed", "hitthebeach", "hkg", "homestead", "host-it", "hotee", "hotepmail", "hotmail", "hotmale", "hushmail", "i-connect", "i-mail", "i-mailbox", "icq", "icqmail", "id-base", "ignmail", "in-box", "iname", "indiatimes", "indocities", "infobank", "internet-club", "iobox", "iqemail", "isleuthmail", "jagex3d", "jahoopa", "jaydemail", "jewishmail", "jipi", "jippii", "jmail", "joymail", "jpostmail", "juniormail", "juno", "justicemail", "kazaa", "kebi", "keftamail", "keromail", "kittymail", "kmail", "kmsp", "ksanmail", "kube93mail", "kurir", "lakmail", "laoffices", "latinmail", "linuxmail", "loadmail", "longhornmail", "looksmart", "lovefootball", "lucidpc", "lycos", "lycosemail", "lycosmail", "m321", "macbox", "madcreations", "mail1st", "mailcity", "mailexcite", "mailgate", "mailops", "mailpanda", "mailplanet", "mailspace", "mailstart", "mailstartplus", "mailstates", "mailtag", "mailwire", "maltesemail", "mancity", "mantramail", "marchmail", "mauimail", "medmail", "medscape", "medsite", "megapoint", "merseymail", "millionairemail", "mini-mail", "mixmail", "mochamail", "morrowind", "moscowoffice", "mrpost", "msgbox", "msgto", "msn", "muslimemail", "mycampus", "mycool", "mygrabber", "myneo", "myownemail", "mypad", "mypersonalemail", "myrealbox", "n2mail", "nameplanet", "nandomail", "netaddress", "netfirms", "netmanor", "netnet", "netnoir", "netroamer", "netscape", "nettaxi", "netwow", "newmail", "newyorkcity", "newyorkoffice", "nexxmail", "nightmail", "nimail", "norikomail", "ntscan", "officedomain", "onenetnow", "operamail", "pakistanmail", "parisoffice", "parsmail", "pbmail", "pconnections", "pemail", "pinoymail", "planetall", "planetdirect", "planetearthinter", "planetside", "pmail", "pokefan", "polbox", "pop2web", "popaccount", "popchecker", "popmail", "portableoffice", "postmaster", "pousa", "probemail", "profimailer", "prolaunch", "prontomail", "purpleturtle", "quios", "racemail", "ragingbull", "ratt-n-roll", "readmail", "realradiomail", "rediffmail", "redseven", "registration", "remarqmail", "richmondhill", "robotmail", "rocketmail", "romymichele", "roosh", "rshelp", "rsnews", "rsnmail", "rsplanet", "runbox", "runescapehelp", "runescapenews", "runescapeplanet", "sacbeemail", "safarimail", "sagra", "saintmail", "salu", "samilan", "sawasdee", "schoolemail", "screenname", "seattlelab", "sfgiants", "shadowbane", "sharewaredevelopers", "shorturl", "shoutmail", "skunkbox", "smartvia", "snoopymail", "solidmedia", "sonicnetmail", "spanmail", "speedymail", "sphosting", "spl", "splendiferous", "ssl", "starting-point", "startmedia", "startrekmail", "startribune", "stbmail", "stealthmail", "supernews", "surfy", "switchboardmail", "sydneyoffice", "t-email", "talk21", "tbwt", "telekbird", "thedoctorspostoffice", "thedoghousemail", "theheadoffice", "thepassword", "tipit", "topteam", "torchmail", "total-recall-mailorder", "totaltools", "truthmail", "uboot", "ucs", "ultimaonline", "umailme", "unicum", "up2me", "usulogin", "uswestmail", "utopiadevil", "uymail", "valise", "vcmail", "virginriver", "virtual-mail", "vlmail", "vpop3", "wallstreetview", "web2mail", "webinbox", "webmail", "webmailer", "weezee", "westmail", "wickedmail", "wildemail", "winbox", "winmx", "wongfaye", "world4you", "worldmailer", "wowmail", "x-sport", "xanga", "xmail", "xoommail", "yachtemail", "yahoo", "yawmail", "yesbox", "ynnmail", "youpy", "yourmail", "yyhmail", "zcities", "zdnetmail", "zdnetonebox", "zeeks", "zensearch", "ziplip", "zipmail", "znap", "zwap", "zxmail", "zybez", "zzn", };
		domainCharacters = new char[domainNames.length][];
		for (int i = 0; i < domainNames.length; i++) {
			Censor.domainCharacters[i] = domainNames[i].toCharArray();
		}
		
		/**
		 * Badwords.
		 */
		String[] badwords = new String[]{ "!)ick", "4uck", "ahole", "anal", "angelfire", "anus", "arse", "asbandit", "ashole", "asmonkey", "ass", "asses", "aswhip", "aswipe", "autorune", "baitch", "barstard", "barsterd", "bastard", "basterd", "bathterd", "battyboy", "bellend", "bestiality", "biatch", "bich", "biotch", "bisex", "bitch", "blodrag", "blojob", "blowjob", "blowme", "boloc", "bolock", "bolok", "bolox", "bondage", "boner", "boob", "bovinelabs", "breast", "btch", "buga", "buger", "butmonkey", "butt", "bych", "bytch", "cack", "cheat", "chink", "chit", "cjb", "clit", "coc", "cocain", "cocaine", "cock", "cockeater", "cockend", "cockless", "cocklover", "cockloving", "cockluver", "cockrider", "cockrocket", "cockrub", "cocktaster", "cocktease", "cocktoucher", "cohc", "cok", "condom", "coon", "coprophilia", "coq", "cox", "crap", "creditcard", "crud", "cum", "cuniling", "cunt", "cyber", "damm", "damn", "damnit", "dhick", "dhik", "dhix", "dic", "dick", "dik", "dildo", "diq", "dix", "dumass", "dumbass", "ecstacy", "ejaculat", "ejaculate", "erection", "excrement", "excrete", "fac", "fack", "faeces", "fag", "fagot", "fak", "fannies", "fanny", "faq", "fark", "fart", "faucking", "fawk", "fck", "fcuk", "fec", "feck", "feg", "fek", "felat", "felate", "felch", "feq", "fhagot", "fhuck", "fhuk", "fhuq", "fk", "fluck", "foc", "fock", "foek", "fok", "foq", "freesex", "fruck", "fuack", "fuc", "fuck", "fudgepacker", "fuhck", "fuhk", "fuick", "fujpacker", "fuk", "fukc", "fuq", "fux", "fyck", "gangrap", "gangrape", "gay", "gayblass", "gayblass hole", "gecities", "gecity", "genital", "geocities", "geocity", "gey", "ghay", "ghey", "gook", "handjob", "hardcoresex", "hash", "hashish", "heroin", "hetro", "hitler", "homo", "hooker", "hore", "hornie", "horny", "horsecock", "hotmail", "hotmale", "htp", "incest", "jiz", "koc", "kock", "kok", "koq", "krap", "kunt", "kweer", "labia", "labium", "lesbian", "lesbo", "lesy", "lez", "lick", "lsd", "marijuana", "masterbat", "masterbate", "masturbat", "masturbate", "minge", "mofo", "mofos", "molest", "motherfuck", "motherfucker", "motherfunker", "msn", "musterbat", "musterbate", "n199a", "n19a", "n1gga", "naked", "natsi", "natzi", "nazi", "necrophilia", "negro", "nhiga", "nhiger", "niga", "niger", "nigr", "niple", "nob", "nonce", "nude", "nuts", "oral", "orgasm", "orgies", "orgy", "paci", "paedo", "paedophil", "paedophile", "paki", "panties", "panty", "pascode", "pasw", "pasward", "paswerd", "paswird", "pasword", "paswurd", "pedo", "pedophil", "pedophile", "penes", "penis", "penus", "perv", "pervert", "phuff", "pilock", "pimp", "piss", "pofter", "ponce", "porn", "porno", "pric", "prick", "prik", "prostitut", "prostitute", "pscode", "psword", "puccy", "puf", "pufs", "pusi", "puss", "pussy", "pusy", "pw", "pword", "pws", "qok", "queer", "quim", "qweer", "raip", "raipe", "raiping", "raipist", "rape", "raping", "rapist", "rectal", "rectum", "retard", "rshakz", "rugmuncher", "scank", "scanq", "schit", "screw", "scrotum", "seks", "semen", "sex", "sextoy", "shag", "shat", "sheit", "shet", "shiet", "shit", "shiz", "shiznit", "shlong", "sht", "shti", "siht", "skanc", "skank", "skanq", "slag", "slaper", "slit", "slut", "smeg", "sodomy", "spank", "spastic", "spaz", "sperm", "sphincter", "sphosting", "spunk", "sqank", "stalk", "stfu", "suc", "sucer", "suck", "suk", "suq", "sux", "sxy", "t)ick", "t)ickhead", "tampon", "testes", "testicle", "testis", "throb", "tit", "titties", "toolkit", "toser", "tosr", "turd", "twat", "undress", "upric", "urinat", "urinate", "urine", "vadge", "vagina", "vegina", "vibrator", "vitu", "vvv", "vvw", "vwv", "vww", "vze", "wang", "wank", "wannahavesex", "whore", "wiger", "willies", "willy", "wnker", "wop", "wvv", "wvw", "ww", "wwv", "www", "yaho", "zoophilia", };
		badwordCharacters = new char[badwords.length][];
		for (int i = 0; i < badwords.length; i++) {
			Censor.badwordCharacters[i] = badwords[i].toCharArray();
		}
	}
}
