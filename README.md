# news-articles

News articles rest api

## Getting started

#### Build project

```shell
./gradlew clean build
```

#### Check code coverage

```shell
./gradlew jacocoTestReport
```

#### Run project

```shell
./gradlew bootRun
```

#### Add article example and response

```shell
curl --request POST \
  --url http://localhost:8080/news \
  --header 'content-type: application/json' \
  --data '{"header":"Operative motivating projection","shortDesc":"Subluxation of MCP joint of right ring finger","text":"Subluxation of metacarpophalangeal joint of right ring finger","author":"Cristie Awmack","keyword":"Vagram","publishDate":1631440612723}'
```

##### response 201

```text
Success
```

#### Update article example and response

```shell
curl --request PUT \
  --url http://localhost:8080/news \
  --header 'content-type: application/json' \
  --data '{"id":100,"header":"Operative motivating projection","shortDesc":"Subluxation of MCP joint of right ring finger","text":"Subluxation of metacarpophalangeal joint of right ring finger","author":"Cristie Awmack","keyword":"Vagram1","publishDate":1631440612723}'
```

##### response 202

```text
Success
```

#### Get article

```shell
curl --request GET \
  --url http://localhost:8080/news/1 
```

##### response 200

```json
{
  "id": 1,
  "header": "Mandatory 6th generation middleware",
  "shortDesc": "Poisoning by diagnostic agents, self-harm, sequela",
  "text": "Poisoning by diagnostic agents, intentional self-harm, sequela",
  "publishDate": 1631445092338,
  "author": "Lebbie Withrop",
  "keyword": "Wrapsafe"
}
```

#### Delete article

```shell
curl --request DELETE \
  --url http://localhost:8080/news/100 
```

##### response 200

```text
Success
```

#### Get Articles by Author

```shell
curl --request GET \
  --url 'http://localhost:8080/news/author?name=Isacco%20Dimitresco' 
```

##### response 200

```json
[
  {
    "id": 5,
    "header": "Upgradable responsive superstructure",
    "shortDesc": "Superficial foreign body of right ear",
    "text": "Superficial foreign body of right ear",
    "publishDate": 1631446190168,
    "author": "Isacco Dimitresco",
    "keyword": "Vagram"
  }
]
```

#### Get Articles by keyword

```shell
curl --request GET \
  --url 'http://localhost:8080/news/keyword?value=Viva' 
```

##### response 200

```json
[
  {
    "id": 3,
    "header": "Mandatory multi-tasking monitoring",
    "shortDesc": "Burns of 60-69% of body surfc w 0% to 9% third degree burns",
    "text": "Burns involving 60-69% of body surface with 0% to 9% third degree burns",
    "publishDate": 1631445136500,
    "author": "Abdul Marre",
    "keyword": "Viva"
  },
  {
    "id": 70,
    "header": "Phased intermediate approach",
    "shortDesc": "Malignant carcinoid tumor of the cecum",
    "text": "Malignant carcinoid tumor of the cecum",
    "publishDate": 1631445136500,
    "author": "Essa Treverton",
    "keyword": "Viva"
  }
]
```

#### Get articles between date

```shell
curl --request GET \
  --url 'http://localhost:8080/news/betweenDate?start=1631440612723&end=1631440612723' \
```

##### response 200

```json
[
  {
    "id": 1,
    "header": "Mandatory 6th generation middleware",
    "shortDesc": "Poisoning by diagnostic agents, self-harm, sequela",
    "text": "Poisoning by diagnostic agents, intentional self-harm, sequela",
    "publishDate": 1631445119290,
    "author": "Lebbie Withrop",
    "keyword": "Wrapsafe"
  },
  {
    "id": 2,
    "header": "Innovative neutral circuit",
    "shortDesc": "Nondisp seg fx shaft of humer, r arm, 7thG",
    "text": "Nondisplaced segmental fracture of shaft of humerus, right arm, subsequent encounter for fracture with delayed healing",
    "publishDate": 1631445119290,
    "author": "Laurice Mullord",
    "keyword": "Keylex"
  },
  {
    "id": 3,
    "header": "Mandatory multi-tasking monitoring",
    "shortDesc": "Burns of 60-69% of body surfc w 0% to 9% third degree burns",
    "text": "Burns involving 60-69% of body surface with 0% to 9% third degree burns",
    "publishDate": 1631445119290,
    "author": "Abdul Marre",
    "keyword": "Viva"
  },
  {
    "id": 4,
    "header": "Multi-layered explicit time-frame",
    "shortDesc": "Age-rel osteopor w crnt path fx, unsp site, 7thG",
    "text": "Age-related osteoporosis with current pathological fracture, unspecified site, subsequent encounter for fracture with delayed healing",
    "publishDate": 1631445119290,
    "author": "Atlante Ovize",
    "keyword": "Hatity"
  }]
```

#### TODO

* Unit test for repo, service and negative test case for controller
* request sanitization
* pagination for list of data
* Improve code coverage 