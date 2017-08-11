### Use locust to know how many concurrent users can my application support

### Meaning of requests.csv

Requests, failures, min. max. avg. response times, content and requests per second

```
Method  Name   #requests   #failures   Median response time   Average response time   Min response time   Max response time   Average content size   Requests/s
GET    /home   574         0           5900                   6363                    5596                17141               1214                   51.50
```

### Meaning of distribution.csv

If your target is to have 300ms at most, you can just cover the 66% requests so you will take the risk of your 34% percent of user to lose.

```
Method  Name    #requests   50%  66%    75%  80%    90%     95%    98%   99%    100%
GET    /home    14151       160  290    400  600    800     1100   1700  2000   13934
```