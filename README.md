# Kafka et Spring Cloud Streams : Application de Traitement de Données en Temps Réel

## Description
Ce projet implémente une application de traitement de données en temps réel en utilisant **Apache Kafka**, **Spring Cloud Streams** et **Spring Boot**. Il se compose de plusieurs composants :
- **Service Producteur** : Envoie des données vers des topics Kafka via un contrôleur REST.
- **Service Consommateur** : Consomme des données depuis des topics Kafka et les traite.
- **Service Fournisseur** : Sert de fournisseur de données pour les topics Kafka.
- **Service d'Analyse en Flux** : Utilise Kafka Streams pour traiter et analyser les données en temps réel.
- **Application Web** : Affiche les résultats de l'analyse des données en temps réel.

## Technologies Utilisées
- **Apache Kafka** : Pour la gestion du broker de messages.
- **Spring Cloud Streams** : Pour le traitement des flux de données.
- **Spring Boot** : Pour les microservices backend.
- **Spring Web** : Pour l'API REST et l'interface web.


