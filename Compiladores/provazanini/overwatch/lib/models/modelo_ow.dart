class ModeloOw {
  CompetitiveStats _competitiveStats;
  String _name;
  int _rating;
  String _ratingIcon;
  List<Ratings> _ratings;

  ModeloOw(
      {CompetitiveStats competitiveStats,
      String name,
      int rating,
      String ratingIcon,
      List<Ratings> ratings}) {
    this._competitiveStats = competitiveStats;
    this._name = name;
    this._rating = rating;
    this._ratingIcon = ratingIcon;
    this._ratings = ratings;
  }

  CompetitiveStats get competitiveStats => _competitiveStats;
  set competitiveStats(CompetitiveStats competitiveStats) =>
      _competitiveStats = competitiveStats;
  String get name => _name;
  set name(String name) => _name = name;
  int get rating => _rating;
  set rating(int rating) => _rating = rating;
  String get ratingIcon => _ratingIcon;
  set ratingIcon(String ratingIcon) => _ratingIcon = ratingIcon;
  List<Ratings> get ratings => _ratings;
  set ratings(List<Ratings> ratings) => _ratings = ratings;

  ModeloOw.fromJson(Map<String, dynamic> json) {
    _competitiveStats = json['competitiveStats'] != null
        ? new CompetitiveStats.fromJson(json['competitiveStats'])
        : null;
    _name = json['name'];
    _rating = json['rating'];
    _ratingIcon = json['ratingIcon'];
    if (json['ratings'] != null) {
      _ratings = new List<Ratings>();
      json['ratings'].forEach((v) {
        _ratings.add(new Ratings.fromJson(v));
      });
    }
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this._competitiveStats != null) {
      data['competitiveStats'] = this._competitiveStats.toJson();
    }
    data['name'] = this._name;
    data['rating'] = this._rating;
    data['ratingIcon'] = this._ratingIcon;
    if (this._ratings != null) {
      data['ratings'] = this._ratings.map((v) => v.toJson()).toList();
    }
    return data;
  }
}

class CompetitiveStats {
  CareerStats _careerStats;

  CompetitiveStats({CareerStats careerStats}) {
    this._careerStats = careerStats;
  }

  CareerStats get careerStats => _careerStats;
  set careerStats(CareerStats careerStats) => _careerStats = careerStats;

  CompetitiveStats.fromJson(Map<String, dynamic> json) {
    _careerStats = json['careerStats'] != null
        ? new CareerStats.fromJson(json['careerStats'])
        : null;
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this._careerStats != null) {
      data['careerStats'] = this._careerStats.toJson();
    }
    return data;
  }
}

class CareerStats {
  AllHeroes _allHeroes;

  CareerStats({AllHeroes allHeroes}) {
    this._allHeroes = allHeroes;
  }

  AllHeroes get allHeroes => _allHeroes;
  set allHeroes(AllHeroes allHeroes) => _allHeroes = allHeroes;

  CareerStats.fromJson(Map<String, dynamic> json) {
    _allHeroes = json['allHeroes'] != null
        ? new AllHeroes.fromJson(json['allHeroes'])
        : null;
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this._allHeroes != null) {
      data['allHeroes'] = this._allHeroes.toJson();
    }
    return data;
  }
}

class AllHeroes {
  Game _game;

  AllHeroes({Game game}) {
    this._game = game;
  }

  Game get game => _game;
  set game(Game game) => _game = game;

  AllHeroes.fromJson(Map<String, dynamic> json) {
    _game = json['game'] != null ? new Game.fromJson(json['game']) : null;
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this._game != null) {
      data['game'] = this._game.toJson();
    }
    return data;
  }
}

class Game {
  int _gamesLost;
  int _gamesPlayed;
  int _gamesTied;
  int _gamesWon;
  String _timePlayed;

  Game(
      {int gamesLost,
      int gamesPlayed,
      int gamesTied,
      int gamesWon,
      String timePlayed}) {
    this._gamesLost = gamesLost;
    this._gamesPlayed = gamesPlayed;
    this._gamesTied = gamesTied;
    this._gamesWon = gamesWon;
    this._timePlayed = timePlayed;
  }

  int get gamesLost => _gamesLost;
  set gamesLost(int gamesLost) => _gamesLost = gamesLost;
  int get gamesPlayed => _gamesPlayed;
  set gamesPlayed(int gamesPlayed) => _gamesPlayed = gamesPlayed;
  int get gamesTied => _gamesTied;
  set gamesTied(int gamesTied) => _gamesTied = gamesTied;
  int get gamesWon => _gamesWon;
  set gamesWon(int gamesWon) => _gamesWon = gamesWon;
  String get timePlayed => _timePlayed;
  set timePlayed(String timePlayed) => _timePlayed = timePlayed;

  Game.fromJson(Map<String, dynamic> json) {
    _gamesLost = json['gamesLost'];
    _gamesPlayed = json['gamesPlayed'];
    _gamesTied = json['gamesTied'];
    _gamesWon = json['gamesWon'];
    _timePlayed = json['timePlayed'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['gamesLost'] = this._gamesLost;
    data['gamesPlayed'] = this._gamesPlayed;
    data['gamesTied'] = this._gamesTied;
    data['gamesWon'] = this._gamesWon;
    data['timePlayed'] = this._timePlayed;
    return data;
  }
}

class Ratings {
  int _level;
  String _role;
  String _rankIcon;

  Ratings({int level, String role, String rankIcon}) {
    this._level = level;
    this._role = role;
    this._rankIcon = rankIcon;
  }

  int get level => _level;
  set level(int level) => _level = level;
  String get role => _role;
  set role(String role) => _role = role;
  String get rankIcon => _rankIcon;
  set rankIcon(String rankIcon) => _rankIcon = rankIcon;

  Ratings.fromJson(Map<String, dynamic> json) {
    _level = json['level'];
    _role = json['role'];
    _rankIcon = json['rankIcon'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['level'] = this._level;
    data['role'] = this._role;
    data['rankIcon'] = this._rankIcon;
    return data;
  }
}
