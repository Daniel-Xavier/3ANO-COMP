import 'package:flutter/material.dart';
import 'package:overwatch/models/modelo_ow.dart';
import 'package:overwatch/telas/tela_2.dart';
import 'package:overwatch/utilities/network_helper.dart';

class Tela1 extends StatefulWidget {
  final String title;

  const Tela1({Key key, this.title = 'Home'}) : super(key: key);

  @override
  _Tela1 createState() => _Tela1();
}

class _Tela1 extends State<Tela1> {
  final controlador = TextEditingController();
  ModeloOw dados_1 = new ModeloOw();

  Future fetchImagem() async {
    var requisicao = NetworkHelper(
        url: 'https://ow-api.com/v1/stats/pc/us/${controlador.text}/complete');
    dados_1 = ModeloOw.fromJson(await requisicao.getData());
  }

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        body: Column(
          children: [
            SizedBox(
                width: 300,
                height: 300,
                child: Image.network(
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/5/55/Overwatch_circle_logo.svg/1200px-Overwatch_circle_logo.svg.png")),
            //
            TextField(
              controller: controlador,
              decoration: InputDecoration(
                  hintText: "Formato: User-1234 ",
                  labelText: "Informe sua batlletag:",
                  icon: Icon(Icons.drive_file_rename_outline)),
            ),
            //
            RaisedButton(
                color: Colors.grey[500],
                shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(50),
                    side: BorderSide(color: Colors.black)),
                child: Text('Mostrar rank'),
                textColor: Colors.white,
                onPressed: () async {
                  await fetchImagem();
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                        builder: (context) => Tela2(dados: dados_1)),
                  );
                }),
          ],
        ),
      ),
    );
  }
}
