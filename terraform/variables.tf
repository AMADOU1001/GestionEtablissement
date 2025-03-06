variable "replicas" {
  description = "Nombre de réplicas pour chaque microservice"
  type        = number
  default     = 2
}

variable "image_prefix" {
  description = "Préfixe des images Docker"
  type        = string
  default     = "docker.io"
}