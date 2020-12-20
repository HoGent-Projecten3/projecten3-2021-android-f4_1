package com.example.faithandroid.models

/**
 * Class that supports the steps needed to complete a goal
 */
data class Step (
   /**
    * @property id is the id of a step
    * @property stepText is the text that is displayed for this step
    */
   var id: Int = 0,
   var stepText: String
)