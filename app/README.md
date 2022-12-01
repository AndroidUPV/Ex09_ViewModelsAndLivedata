# Ex09_ViewModelsAndLiveData
Lecture 02 - Development of Graphical User Interfaces (GUI)

- A TextView displays the number of likes, which can be increased/decreased by using the provided Buttons.
- A ViewModel holds the mutable number of likes (MutableLiveData) and an immutable backing property (LiveData) exposes this data to the UI.
- Transformations.map() is used to transform the Int value into a String value to easily display the information on the screen.