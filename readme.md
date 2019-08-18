# infohub-darklaunch-ui

## 1. About feature toggle
Feature Toggles are a powerful technique, allowing teams to modify system behavior without changing code.
Also called features flag, it allows to enable/disable features at runtime without deployment. During developments you implement multiple behaviours in your code. At runtime, the executed one is selected by evaluating conditions. 
feature toggle 主流的技术是FF4J 和 togglz,我们选用了FF4J。使用elasticsearch作为持久化存储
## 2. Why is FF4J
我们在以下几个方面对比了FF4J和togglz

|  Togglz   |  FF4J |
Group  support|No|Yes
Admin Console | simple|rich
AOP support   | No|Yes
Feature Strategy |Yes|Yes
Feature store |Memory / DB | Memory / DB
Feature Audit | No|Yes
Restful API    |No|Yes
Spring Boot Starter |Yes|Yes
Feature Cache |CachingStateRepository|Memory / DB
Maintenance  | No longer officially maintained | Yes



   
