
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
- **URL:** `/api/depense/all/depense/{date}`

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

### Get Recette Total by Employee
- **Method:** `GET`
- **URL:** `/api/vente/all/recette/{id_employee}`

### Get Benefice by Employee (All Time)
- **Method:** `GET`
- **URL:** `/api/vente/benefice/{id}`

### Get Benefice by Employee and Date
- **Method:** `GET`
- **URL:** `/api/vente/benefice/{id}/{date}`

### Get Perte by Employee (All Time)
- **Method:** `GET`
- **URL:** `/api/vente/perte/{id}`

### Get Perte by Employee and Date
- **Method:** `GET`
- **URL:** `/api/vente/perte/{id}/{date}`

### Get Recette by Employee (All Time)
- **Method:** `GET`
- **URL:** `/api/vente/recette/{id}`

### Get Recette by Employee and Date
- **Method:** `GET`
- **URL:** `/api/vente/recette/{id}/{date}`
```

Voici les URL a utilise pour recuperer et envoyer les fichier a l API vokye sachant que les insert update son envoyer sous forme de JSON.