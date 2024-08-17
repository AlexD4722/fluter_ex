import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  List<dynamic> places = [];
  bool isLoading = true;

  @override
  void initState() {
    super.initState();
    _fetchPlaces();
  }

  Future<void> _fetchPlaces() async {
    final response = await http.get(Uri.parse('http://localhost:8080/api/getAllPlace'));

    if (response.statusCode == 200) {
      setState(() {
        places = json.decode(response.body);
        isLoading = false;
      });
    } else {
      // Handle the error
      setState(() {
        isLoading = false;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Popular Destinations'),
      ),
      body: isLoading
          ? Center(child: CircularProgressIndicator())
          : GridView.builder(
        gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
          crossAxisCount: 2, // 2 items per row
          childAspectRatio: 3 / 2, // Adjust the aspect ratio as needed
        ),
        itemCount: places.length,
        itemBuilder: (context, index) {
          final place = places[index];
          return Card(
            child: Container(
              width: double.infinity,
              decoration: BoxDecoration(
                borderRadius: BorderRadius.circular(8),
                image: DecorationImage(
                  image: NetworkImage(place['imageUrl']),
                  fit: BoxFit.cover,
                ),
              ),
              child: Align(
                alignment: Alignment.bottomCenter,
                child: Container(
                  color: Colors.black.withOpacity(0.5),
                  padding: const EdgeInsets.all(4.0),
                  child: Column(
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      Text(
                        place['name'],
                        style: const TextStyle(
                          color: Colors.white,
                          fontSize: 12,
                        ),
                      ),
                      Text(
                        place['description'],
                        style: const TextStyle(
                          color: Colors.white,
                          fontSize: 12,
                        ),
                      ),
                    ],
                  ),
                ),
              ),
            )
          );
        },
      ),
    );
  }
}