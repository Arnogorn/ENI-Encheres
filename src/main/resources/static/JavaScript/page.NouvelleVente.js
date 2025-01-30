
function addImage(event) {
    const files = event.target.files;
    const container = document.getElementById('imagesContainer');

    for (let i = 0; i < files.length; i++) {
        const reader = new FileReader();
        reader.onload = function(e) {
            const imgContainer = document.createElement('div');
            imgContainer.classList.add('image-container');

            const img = document.createElement('img');
            img.src = e.target.result;
            img.alt = 'Aperçu de l\'image';

            const btn = document.createElement('button');
            btn.innerHTML = 'X';
            btn.onclick = function() {
                container.removeChild(imgContainer);
            };

            imgContainer.appendChild(img);
            imgContainer.appendChild(btn);
            container.appendChild(imgContainer);
        };
        reader.readAsDataURL(files[i]);
    }
}

function enregistrerAnnonce() {
    const formulaireVente = document.getElementById('formulaireVente');
    const formulaireRetrait = document.getElementById('formulaireRetrait');

    if (formulaireVente.reportValidity() && formulaireRetrait.reportValidity()) {
        alert('Votre annonce a été enregistrés.');
    } else {
        alert('Veuillez remplir tous les champs obligatoires.');
    }
}


