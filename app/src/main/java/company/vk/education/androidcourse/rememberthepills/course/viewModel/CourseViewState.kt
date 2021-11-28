package company.vk.education.androidcourse.rememberthepills.course.viewModel

import company.vk.education.androidcourse.rememberthepills.components.models.FormScreenMode
import company.vk.education.androidcourse.rememberthepills.components.models.TextedItem

data class CourseViewState(val drugId: Int?,
                           val courseId: Int?,
                           var measurementItems: Array<out TextedItem>,
                           var selectedMeasurementItem: TextedItem,
                           var quantity: Int?,
                           var foodAddictionItems: Array<out TextedItem>,
                           var selectedFoodAddictionItem: TextedItem,
                           var startedDateInMilliseconds: Long?,
                           var endedDateInMilliseconds: Long?,
                           var frequencyInDays: Int?,
                           var intakeTimesInMinutes: List<Int>,
                           val screenMode: FormScreenMode)