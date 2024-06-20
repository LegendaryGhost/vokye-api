
# Documentation API

## TYPE_DEPENSE (`/api/typedepense/`)

### Get All Type Depenses
- **Method:** `GET`
- **URL:** `/api/typedepense/read`
### Get Type Depense by ID
- **Method:** `GET`
- **URL:** `/api/typedepense/{id_typeDepense}`

### Insert Type Depense
- **Method:** `POST`
- **URL:** `/api/typedepense/`
- **Body:**
  ```json
  {
      "id_type_depense": null,
      "designation": "variable"
  }
  ```
  ### Update Type Depense
- **Method:** `PUT`
- **URL:** `/api/typedepense/`
- **Body:**
  ```json
  {
      "id_type_depense": 2,
      "designation": "variable"
  }
  ```

## DEPENSE (`/api/depense/`)

### Insert Depense
- **Method:** `POST`
- **URL:** `/api/depense/`
- **Body:**
  ```json
  {
      "id_depense": null,
      "typeDepense": {
          "id_type_depense": 1,
          "designation": null
      },
      "prix": 200.0,
      "date_depense": "2024-01-05"
  }
  ```

### Update Depense
- **Method:** `POST`
- **URL:** `/api/depense/`
- **Body:**
  ```json
  {
      "id_depense": 2,
      "typeDepense": {
          "id_type_depense": 1,
          "designation": null
      },
      "prix": 200.0,
      "date_depense": "2024-01-05"
  }
  ```

### Get Depense by Date
- **Method:** `GET`
- **URL:** `/api/depense/all/depense/2024-06-12`

### Get Total Depense
- **Method:** `GET`
- **URL:** `/api/depense/all/depense/`

## VENTE (`/api/vente/`)

### Insert Vente
- **Method:** `POST`
- **URL:** `/api/vente/`
- **Body:**
  ```json
  {
      "id_vente": null,
      "id_point_vente": 1,
      "id_chariot": 1,
      "id_produit": 1,
      "quantite": 3,
      "date_vente": "2024-01-20"
  }
  ```

### Update Vente
- **Method:** `POST`
- **URL:** `/api/vente/`
- **Body:**
  ```json
  {
      "id_vente": 1,
      "id_point_vente": 1,
      "id_chariot": 1,
      "id_produit": 1,
      "quantite": 3,
      "date_vente": "2024-01-20"
  }
  ```

### Get Total Recette
- **Method:** `GET`
- **URL:** `/api/vente/all/recette/`
- ### Get Total Recette Before
- **Method:** `GET`
- **URL:** `/api/vente/all/recette/2024-06-12`
- ### Get Prediction on date
- **Method:** `GET`
- **URL:** `/api/vente/prediction/2024-06-12`

```

Voici les URL a utilise pour recuperer et envoyer les fichier a l API vokye sachant que les insert update son envoyer sous forme de JSON.