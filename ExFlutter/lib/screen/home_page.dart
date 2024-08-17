import 'package:flutter/material.dart';
import 'dart:convert';
import 'package:http/http.dart' as http;
class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  List<dynamic> places = [];

  @override
  void initState() {
    super.initState();
    fetchPlaces();
  }

  Future<void> fetchPlaces() async {
    try {
      final response = await http.get(Uri.parse('http://localhost:8080/api/getAllPlace'));
      if (response.statusCode == 200) {
        setState(() {
          places = json.decode(response.body);
        });
      } else {
        print('Failed to load places: ${response.statusCode}');
        throw Exception('Failed to load places');
      }
    } catch (e) {
      print('Error: $e');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Popular Destinations'),
      ),
      body: ListView.builder(
        itemCount: places.length,
        itemBuilder: (context, index) {
          return ListTile(
            title: Text(places[index]['name']),
            subtitle: Text(places[index]['description']),
          );
        },
      ),
    );
  }
}