import 'package:flutter/material.dart';
import 'package:overwatch/models/modelo_ow.dart';
import 'package:flutter/cupertino.dart';

class Tela2 extends StatefulWidget {
  final ModeloOw dadosModeloow;
  final CompetitiveStats dadosCompstats;
  final CareerStats dadosCareerstats;
  final AllHeroes dadoAllheroes;
  final Assists dadosAssists;
  final Best dadosBest;
  final Combat dadosCombat;
  final Game dadosGame;
  final Games dadosGames;
  final Ratings dadosRatings;

  const Tela2({
    Key key,
    @required this.dadosModeloow,
    @required this.dadosCompstats,
    @required this.dadosCareerstats,
    @required this.dadoAllheroes,
    @required this.dadosAssists,
    @required this.dadosBest,
    @required this.dadosCombat,
    @required this.dadosGame,
    @required this.dadosGames,
    @required this.dadosRatings,
  }) : super(key: key);
  @override
  _Tela2State createState() => _Tela2State();
}

class _Tela2State extends State<Tela2> {
  TextEditingController controlador;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text(
            " Seu Perfil ",
          ),
          backgroundColor: Colors.orange[300],
        ),
        body: Column(
          children: [
            //
            Container(
              child: Image.network(
                  "https://pbs.twimg.com/media/Eh0cbo1VgAAc1zr.jpg"),
            ),
            Container(
              child: Image.network(widget.dadosModeloow.ratingIcon),
            ),
            Container(
              child: Text(widget.dadosModeloow.rating.toString()),
            )

            //
          ],
        ));
  }
}
