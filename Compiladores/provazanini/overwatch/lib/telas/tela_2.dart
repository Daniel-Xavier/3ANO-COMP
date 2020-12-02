import 'package:flutter/material.dart';
import 'package:overwatch/models/modelo_ow.dart';
import 'package:flutter/cupertino.dart';

class Tela2 extends StatefulWidget {
  final ModeloOw dados;
  const Tela2({Key key, @required this.dados}) : super(key: key);
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
            SizedBox(
              child: Image.network(widget.dados.ratingIcon),
            )

            //
          ],
        ));
  }
}
