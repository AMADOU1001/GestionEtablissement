output "k8s_services" {
  value = [
    kubernetes_service.gestion_emploi_du_temps_service.metadata[0].name,
    kubernetes_service.gestion_professeurs_service.metadata[0].name,
    kubernetes_service.gestion_cours_service.metadata[0].name
  ]
}