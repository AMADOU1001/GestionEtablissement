// Charger la liste des étudiants
function chargerEtudiants() {
    fetch("http://localhost:8090/api/etudiants")
        .then(response => response.json())
        .then(data => {
            const liste = document.getElementById("liste-etudiants");
            liste.innerHTML = ""; // Effacer la liste avant d'ajouter les nouveaux étudiants
            data.forEach(etudiant => {
                const li = document.createElement("li");
                li.textContent = `${etudiant.nom} ${etudiant.prenom} - ${etudiant.email}`;
                liste.appendChild(li);
            });
        })
        .catch(error => console.error("Erreur lors du chargement des étudiants", error));
}

// Ajouter un étudiant
function ajouterEtudiant(event) {
    event.preventDefault();

    const nom = document.getElementById("nom").value;
    const prenom = document.getElementById("prenom").value;
    const email = document.getElementById("email").value;

    fetch("http://localhost:8090/api/etudiants", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ nom, prenom, email })
    })
        .then(response => {
            if (response.ok) {
                alert("Étudiant ajouté !");
                chargerEtudiants(); // Recharger la liste
            } else {
                alert("Erreur lors de l'ajout de l'étudiant");
            }
        })
        .catch(error => console.error("Erreur lors de l'ajout", error));
}

// Charger la liste des professeurs
function chargerProfesseurs() {
    fetch("http://localhost:8090/api/professeurs")
        .then(response => response.json())
        .then(data => {
            const liste = document.getElementById("liste-professeurs");
            liste.innerHTML = "";
            data.forEach(prof => {
                const li = document.createElement("li");
                li.textContent = `${prof.nom} ${prof.prenom} - ${prof.specialite}`;
                liste.appendChild(li);
            });
        })
        .catch(error => console.error("Erreur lors du chargement des professeurs", error));
}


// Ajouter un professeur
function ajouterProfesseur(event) {
    event.preventDefault();

    const nom = document.getElementById("nom").value;
    const prenom = document.getElementById("prenom").value;
    const specialite = document.getElementById("specialite").value;

    fetch("http://localhost:8090/api/professeurs", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ nom, prenom, specialite })
    })
        .then(response => {
            if (response.ok) {
                alert("Professeur ajouté !");
                chargerProfesseurs();
            } else {
                alert("Erreur lors de l'ajout du professeur");
            }
        })
        .catch(error => console.error("Erreur lors de l'ajout", error));
}