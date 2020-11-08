# Wang Zesong - Project Portfolio Page

## PROJECT: The Schwarzenegger

## Overview
The Schwarzenegger is a desktop command line interface-based app for managing all your needs regarding fitness. With the built-in personal assistant, you are able to track your daily workout and diet sessions based on your profile. If you can type fast, The Schwarzenegger can help you maximise your efficiency for maintaining fitness.

### Summary of Contributions

+ **Role**: Developer

+ **Responsibility**: Workout manager
 
+ **Major enhancement**:
    + **Search Workout Sessions**
        + Functionality: This enhancement allows the user to search for specific workout sessions created on a certain date range or containing certain tags.
        + Justification: This feature improves the product significantly because a user can easily find the session she intends to edit or delete.
      
    + **Command Library**
        + Functionality: This enhancement organises the commands into a hashmap and retrieves correct Command object using user's input as key.
        + Justification: This feature improves the code neatness and reduce long selection statement for menus with many availble commands. 
         
    + **Design Workout Session Meta-info File**
        + Functionality: This enhancement creates the program create a file to store the meta-information of past workout sessions. 
        + Justification: This allows the program not to have to load every past session files at one go but only need to load the meta-information of each session. This greatly reduce the initialization time and makes the program more scalable. 
         
+ **Minor enhancement**:
    + **Date Parser**
        + This feature will parse the user's input into LocalDate. The parser supports 9 formats which gives user max flexibility when using the application.
        
    + **List Workout Sessions**
        + This feature allows the use to view records only ranging from a given period. This helps the users to avoid seeing long list of workout sessions from long time ago.
        
            
+ **Code contribution**: [Functional and Test code](https://nus-cs2113-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=wgzesg&sort=groupTitle&sortWithin=title&since=2020-09-27&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)
      
+ **Other contributions**:
    + Project management:
        + Ensure that the team members are always aware of weekly deadlines and deliverables.
           
    + Documentation:
        + Completed Section 3.4 Workout Menu (Pull Request: [#106](https://github.com/AY2021S1-CS2113T-F11-1/tp/pull/106), [#147](https://github.com/AY2021S1-CS2113T-F11-1/tp/pull/147))
          
    + Community:
        + Reported bugs for other teams in the class (Pull Request: [#36](https://github.com/nus-cs2113-AY2021S1/tp/pulls?q=is%3Aopen+is%3Apr+CS2113-T13-3+)
        + Perform manual testing, reported bugs and gave suggestions to teammates.
             
#### Contributions to the User Guide
```
Given below are sections I contributed to the User Guide.   
They showcase my ability to write documentation targeting end-users.
```
+ [Workout Menu](https://ay2021s1-cs2113t-f11-1.github.io/tp/UserGuide.html#workout-menu) 
      
+ [Search for ingredient](https://ay2021s1-cs2113t-f11-1.github.io/tp/UserGuide.html#workout-help)
      
+ [Search for recipe](https://ay1920s2-cs2113t-m16-2.github.io/tp/UserGuide#344-search-for-recipe-searchrecipe-jin-fa)
      
+ [Search for chore](https://ay1920s2-cs2113t-m16-2.github.io/tp/UserGuide#354-search-for-chore-searchchore-jin-fa)
      
#### Contributions to the Developer Guide
      
```
      Given below are sections I contributed to the Developer Guide. 
      They showcase my ability to write technical documentation and the technical depth of my contributions
      to the project.
```
      
+ [Addition of ingredient](https://ay1920s2-cs2113t-m16-2.github.io/tp/DeveloperGuide#411-addition-of-ingredient)
      
+ [Search for ingredients based on keyword(s)](https://ay1920s2-cs2113t-m16-2.github.io/tp/DeveloperGuide#414-search-for-ingredients-based-on-keywords)
      
+ [Search for recipe based on keyword(s)](https://ay1920s2-cs2113t-m16-2.github.io/tp/DeveloperGuide#425-search-for-recipe-based-on-keywords)
      
+ [Search for chore based on keyword(s)](https://ay1920s2-cs2113t-m16-2.github.io/tp/DeveloperGuide#434-search-for-chore-based-on-keywords)
      
+ [Part of Use cases in Appendix C](https://ay1920s2-cs2113t-m16-2.github.io/tp/DeveloperGuide#appendix-c-value-proposition---use-cases)
      
+ Instructions for Manual Testing in Appendix F (Example: 
        [1](https://ay1920s2-cs2113t-m16-2.github.io/tp/DeveloperGuide#f2-add-an-ingredient)
      , [2](https://ay1920s2-cs2113t-m16-2.github.io/tp/DeveloperGuide#f5-search-for-ingredient)
      , [3](https://ay1920s2-cs2113t-m16-2.github.io/tp/DeveloperGuide#f10-search-for-recipe)
      , [4](https://ay1920s2-cs2113t-m16-2.github.io/tp/DeveloperGuide#f14-search-for-chore))  