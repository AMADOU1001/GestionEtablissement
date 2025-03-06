# Déploiement et Service pour gestion–emploi–du–temps
resource "kubernetes_deployment" "gestion_emploi_du_temps" {
  metadata {
    name = "gestion_emploi_du_temps"
    labels = {
      app = "gestion_emploi_du_temps"
    }
  }
  spec {
    replicas = 2
    selector {
      match_labels = {
        app = "gestion_emploi_du_temps"
      }
    }
    template {
      metadata {
        labels = {
          app = "gestion_emploi_du_temps"
        }
      }
      spec {
        container {
          name  = "gestion_emploi_du_temps"
          image = "docker.io/gestion_emploi_du_temps:latest"
          port {
            container_port = 8085
          }
          # Ajoutez ici les variables d'environnement spécifiques si besoin
        }
      }
    }
  }
}

resource "kubernetes_service" "gestion_emploi_du_temps_service" {
  metadata {
    name = "gestion_emploi_du_temps-service"
  }
  spec {
    selector = {
      app = "gestion_emploi_du_temps"
    }
    port {
      protocol    = "TCP"
      port        = 80
      target_port = 8085
    }
    type = "ClusterIP"
  }
}

# Déploiement et Service pour gestion–professeurs
resource "kubernetes_deployment" "gestion_professeurs" {
  metadata {
    name = "gestion–professeurs"
    labels = {
      app = "gestion_professeurs"
    }
  }
  spec {
    replicas = 2
    selector {
      match_labels = {
        app = "gestion_professeurs"
      }
    }
    template {
      metadata {
        labels = {
          app = "gestion_professeurs"
        }
      }
      spec {
        container {
          name  = "gestion_professeurs"
          image = "docker.io/gestion_professeurs:latest"
          port {
            container_port = 8082
          }
        }
      }
    }
  }
}

resource "kubernetes_service" "gestion_professeurs_service" {
  metadata {
    name = "gestion_professeurs-service"
  }
  spec {
    selector = {
      app = "gestion_professeurs"
    }
    port {
      protocol    = "TCP"
      port        = 80
      target_port = 8082
    }
    type = "ClusterIP"
  }
}

# Déploiement et Service pour gestion–cours
resource "kubernetes_deployment" "gestion_cours" {
  metadata {
    name = "gestion_cours"
    labels = {
      app = "gestion_cours"
    }
  }
  spec {
    replicas = 2
    selector {
      match_labels = {
        app = "gestion_cours"
      }
    }
    template {
      metadata {
        labels = {
          app = "gestion_cours"
        }
      }
      spec {
        container {
          name  = "gestion_cours"
          image = "docker.io/gestion_cours:latest"
          port {
            container_port = 8083
          }
        }
      }
    }
  }
}

resource "kubernetes_service" "gestion_cours_service" {
  metadata {
    name = "gestion_cours-service"
  }
  spec {
    selector = {
      app = "gestion_cours"
    }
    port {
      protocol    = "TCP"
      port        = 80
      target_port = 8083
    }
    type = "ClusterIP"
  }
}

# Déploiement et Service pour gestion–etudiants
resource "kubernetes_deployment" "gestion_etudiant" {
  metadata {
    name = "gestion_etudiant"
    labels = {
      app = "gestion_etudiant"
    }
  }
  spec {
    replicas = 2
    selector {
      match_labels = {
        app = "gestion_etudiant"
      }
    }
    template {
      metadata {
        labels = {
          app = "gestion_etudiant"
        }
      }
      spec {
        container {
          name  = "gestion_etudiant"
          image = "docker.io/gestion_etudiant:latest"
          port {
            container_port = 8081
          }
        }
      }
    }
  }
}

resource "kubernetes_service" "gestion_etudiant_service" {
  metadata {
    name = "gestion_etudiant-service"
  }
  spec {
    selector = {
      app = "gestion_etudiant"
    }
    port {
      protocol    = "TCP"
      port        = 80
      target_port = 8081
    }
    type = "ClusterIP"
  }
}