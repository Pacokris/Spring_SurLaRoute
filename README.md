# Spring: SurLaRoute

  # Critères de validation
  
    - Le contrôleur contient 1 seule route /doctor/<numéro de l'incarnation>.
    - La route renvoie un JSON pour les 5 dernières incarnations, un statut 303 pour les plus anciennes, sinon elle renvoie un statut 404 avec un message adapté.
    - Le paramètre details permet d'obtenir un JSON avec plus de détails.
    - Le code est disponible sur github.
    
  # Exemples de requêtes
  
  http://localhost:8080/doctor/9
  Renvoie sous format Json le numéro de l'incarnation et le nom.
  
  http://localhost:8080/doctor/13?details=true
  Renvoie sous format Json le numéro de l'incarnation, le nom, le nombre d'épisodes et l'âge de début.
  
  http://localhost:8080/doctor/1
  Renvoie un statut d'erreur 303.
  
  http://localhost:8080/doctor/69
  Renvoie un statut d'erreur 404, avec comme information une chaîne de caractères contenant "Impossible de récupérer             l'incarnation <numéro de l'incarnation>".
