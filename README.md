# Pollen Buddy

A small and experimental Java Wunderground Pollen API library.

## What it do:

Gets you four date pollen prediction in the United States using the Wunderground API using simply your zipcode.

## This library gives you:

1. `String` - Today's date
2. `String` - Today's primary pollen type
3. `String` - Name of the city requested 
4. `Collection<String>` - Four days of pollen index predictions
5. `Set<Date>` - Four dates including today
6. `Integer` - Entered zipcode

## More Info You Don't Care About

Currently there are no existing APIs on the web that gets live pollen data with predictions. This gets you that.

I am open sourcing this library I wrote last year because a few people expressed their interest in using it after I wrote about it in my [blog](http://www.jackyliang.com/jackyresumecoding/2014/6/1/work-android-development-and-life). 

## Note

You can use this anywhere the MIT license permits. 

Please kindly credit me, however, when you use this library, and if possible, contribute back patches when/if necessary.

Do not, I repeat, do **NOT** use this library in a live production settings! 

It uses JSoup to scrape HTML directly off of Wunderground's Pollen site, and Wunderground could tweak their HTML/CSS just a bit, and it would break this library. I am not responsible for you losing millions of dollars.

*Actually that would be pretty cool.*
