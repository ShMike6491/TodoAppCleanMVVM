## About

I didn't delve deeply into the functionality but rather focused more on creating the architecture. 
Therefore, the application doesn't have any special features (it only contains two screens and a couple of functions). 
It's possible to add new tasks, modify task descriptions, and mark something as completed.

<div style="text-align: center;">
  <img src="https://github.com/ShMike6491/TodoAppCleanMVVM/blob/master/screenshot_1.jpg" width="300" style="display: inline-block; margin: 0 10px;">
  <img src="https://github.com/ShMike6491/TodoAppCleanMVVM/blob/master/screenshot_2.jpg" width="300" style="display: inline-block; margin: 0 10px;">
</div>

## Architecture

<img align="center" src="https://github.com/ShMike6491/TodoAppCleanMVVM/blob/master/architecture.jpg" width="400">

The project comprises only three modules, namely:

'Data' for handling data operations in the network and database.
'Domain' where I centralized the core logic, models, and use cases.
The 'Presentation' layer utilized the single-activity MVVM architecture, housing the application class, the main activity, and a couple of fragments implementing screens (for editing, I used a dialog window). Additionally, I placed Navigation and Hilt within this layer.
Each module has its own data and mappers for their transformation (I created them using extension functions).

Dependencies:

Room for database operations. I didn't invent anything for network requests, but I indicated on the diagram where I would do this. 
I pondered for a while on what to use for concurrency and decided to go with coroutines since it's not advisable to rely on external libraries for a clean architecture 
(also, considering the application is very simple, I thought it would be more convenient, although I don't have extensive experience with coroutines). 
I opted for the Navigation Component because it would simplify navigation with dialog windows. 
Hilt was more straightforward and quicker to use for a small project with ViewModels. And of course, the standard Jetpack libraries for MVVM operations.
