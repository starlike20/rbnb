# Java Projet Git - Gestion de Projet Java

## Description
Ce projet est une application Java structurée selon le modèle MVC (Model-View-Controller). Elle permet la gestion des différents aspects d'une réservation immobilière, notamment les appartements, les clients, les employés et les réservations.

L'application inclut des interfaces graphiques pour faciliter l'interaction avec l'utilisateur ainsi que des composants backend robustes pour assurer le traitement des données.

---

## Fonctionnalités principales
- Gestion des appartements : ajout, modification et suppression.
- Gestion des clients : création, modification et consultation.
- Gestion des employés : administration des utilisateurs internes.
- Gestion des réservations : prise en charge des réservations avec calcul de factures.
- Interfaces utilisateur graphiques (Swing) pour une navigation intuitive.

---

## Structure du projet

Le projet est organisé comme suit :

### 1. **Model**
Contient les entités et la couche d'accès aux données :
- Entités : `Appartement`, `Client`, `Employe`, `Reservation`, etc.
- DAO (Data Access Objects) : Gestion des opérations CRUD.

### 2. **View**
Contient les interfaces utilisateur :
- **GUI** : Fenêtres Swing pour une interaction utilisateur avancée (e.g., `JDialogConnexion`, `JFrameReservation`).
- **Console** : Visualisation et interactions en ligne de commande.

### 3. **Controller**
- Logique de contrôle et coordination entre la vue et le modèle.
- Exemple : `Controller.java`, `ControlleurActions.java`.

---

## Prérequis
- **Java Development Kit (JDK)** : version 8 ou supérieure.
- **IDE recommandé** : IntelliJ IDEA, Eclipse ou NetBeans.
- **Bibliothèques Java** : Swing (intégrée dans le JDK).

---

## Installation et exécution

### 1. **Clôner le dépôt**
```bash
git clone <url-du-repository>
```

### 2. **Importer dans un IDE**
- Ouvrez votre IDE préféré.
- Importez le projet comme un projet Java existant.
- Assurez-vous que les chemins des modules sont bien configurés.

### 3. **Exécuter l'application**
- Lancez le fichier principal : `Main.java`.
- Naviguez à travers les fonctionnalités via les interfaces GUI ou console.

---

## Captures d'écran
Des images sont disponibles dans le dossier :
```
src/MVC/view/Gui/images
```

---

## Contribution
Les contributions sont les bienvenues. Veuillez suivre les étapes suivantes :
1. Forkez ce dépôt.
2. Créez une branche pour votre fonctionnalité : `git checkout -b feature/AmazingFeature`.
3. Faites un commit : `git commit -m 'Ajout d\'une fonctionnalité incroyable'`.
4. Poussez la branche : `git push origin feature/AmazingFeature`.
5. Créez une Pull Request.

---

## Auteur
Ce projet a été développé par [Votre Nom/Equipe].

---

## Licence
Ce projet est sous licence MIT - voir le fichier [LICENSE](LICENSE) pour plus de détails.

