# Motor_controller_app





# Aim

This project aims to automate the irrigation system of Indian farmers.



## How to use?

1. Clone the repository
2. Install the required packages.

Some packages are:
 - firebase
 - Mqtt
 - Arduino library such is wifi-clients


# Description
1. This app is used to control the electric pump of an Indian farmer.
2. They can schedule the timing to start their system and also they can remotely control the whole motor system.
3. This application will also update the farmers about the availability of electricity on the field.
<img src="https://github.com/9k-ux/motor_controller_app_final/blob/main/Screenshot_2023-02-26-22-14-33-07_fe2079fa00c6d0413f786a950f5b1b80.jpg">

## How this project was made?

1. First of all a broker (MQTT) was installed on AWS to communicate between hardware and application.
2. Protocols were set for fast realtime data transfer.
3. Firebase was set up to authenticate the user and also to store their data.
4. Topics were set to controll the different events and subscribers were made to get the updates of different events.


6. This project was given the form of an website built on Flask where we used the Linear Regression model to perform predictions.
