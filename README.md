# Pollen Buddy

A small and experimental Java Wunderground Pollen API library.

## Some Description

*Insert better description here*

Currently there are no existing APIs on the web that gets live pollen data with predictions. I wrote this library last year in an Android project I did also called Pollen Buddy where it allowed allergy sufferers like me to monitor pollen levels on a daily and multiple-day basis. I decided to open source this library because a few people expressed their interest in using it after I wrote about it [here](http://www.jackyliang.com/jackyresumecoding/2014/6/1/work-android-development-and-life). 

## Included Functionality

This library returns: 

1. Today's date

2. Today's primary pollen 

3. Name of the city requested based on zipcode

4. Four days of pollen level predictions in the form of a `Double`

5. Four dates including today

## Note

You can use this anywhere the MIT license permits. Please kindly credit me when you use this library, and if possible, contribute back patches when necessary.

Do not, I repeat, do **NOT** use this library in a live production settings! It uses JSoup to scrape HTML directly off of Wunderground's Pollen site, and Wunderground could tweak their HTML just a bit, and it would break this library. I am not responsible for you losing millions of dollars.
