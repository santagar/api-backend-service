from locust import HttpLocust, TaskSet, task

headers = {
    "Accept": "application/json",
    "Content-Type": "application/json"
}

timeout = 30.0 # seconds

payload = '{"name":"Beds R Us","description":"Very basic, small rooms but clean","city":"Santa Ana","rating":2}'

class UserBehavior(TaskSet):
        
    """ 
    def on_start(self):
        create(self)
    """

    @task(1)
    def create(self):
        response = self.client.request(
            method = "POST",
            url = '/api/v1/hotels',
            data = payload,
            headers = headers,
            timeout = timeout,
            verify = False
        )
        if response.status_code != 201:
            print "/api/v1/hotels"

    @task(2)
    def paginate(self):
        response = self.client.request(
            method = "GET",
            url = '/api/v1/hotels?page=0&size=10',
            headers = headers,
            timeout = timeout,
            verify = False
        )
        if response.status_code != 200:
            print "/api/v1/hotels?page=0&size=10"
    
    """   
    @task(1)
    def get_two_things(self):
        self.create()
        self.paginate()
    """

class WebsiteUser(HttpLocust):
    host = "http://localhost:8080"
    task_set = UserBehavior
    min_wait = 0 #2000
    max_wait = 0 #5000