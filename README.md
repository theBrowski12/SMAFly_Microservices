To run ML_Service :venv\Scripts\python.exe -m uvicorn main:app --reload --port 8000  
before running inventroy_Service : make sure redis is installed and run "docker run -d --name mongo-inventory -p 27017:27017 -e MONGO_INITDB_DATABASE=inventory_db mongo:6.0" 
before running notification_Service : run "docker compose up -d" inside
