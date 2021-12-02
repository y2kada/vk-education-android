package company.vk.education.androidcourse.rememberthepills.drugList.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import company.vk.education.androidcourse.rememberthepills.R
import company.vk.education.androidcourse.rememberthepills.components.models.FormScreenMode
import company.vk.education.androidcourse.rememberthepills.drugList.model.DrugEntry
import company.vk.education.androidcourse.rememberthepills.drugList.view.FragmentDrugListDirections

class DrugListAdapter(private val drugEntries: List<DrugEntry>, private val intentForEntries: String) :
    RecyclerView.Adapter<DrugListAdapter.DrugEntryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrugEntryViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_drug_list, parent, false)

        return DrugEntryViewHolder(view)
    }

    override fun onBindViewHolder(holder: DrugEntryViewHolder, position: Int) {
        holder.bind(drugEntries[position], intentForEntries)
    }

    override fun getItemCount() = drugEntries.size

    class DrugEntryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameOfDrug: TextView = itemView.findViewById(R.id.text_drug_list_name_of_drug)
        private val typeOfDrug: TextView = itemView.findViewById(R.id.text_drug_list_type_of_drug)

        fun bind(drugEntry: DrugEntry, intentForEntries: String) {
            // TODO: do sth with all these hardcode values
            if (intentForEntries == "choose") {
                itemView.findViewById<LinearLayout>(R.id.layout_drug_entry_info).setOnClickListener {
                    val action = FragmentDrugListDirections.actionFragmentDrugListToFragmentCourse(FormScreenMode.CREATING)
                        .setDrugId(drugEntry.idOfDrug)
                    it.findNavController().navigate(action)
                }
            }
            else if (intentForEntries == "edit") {
                val buttonEntryEdit: Button = itemView.findViewById(R.id.button_drug_entry_edit)
                buttonEntryEdit.visibility = View.VISIBLE
                buttonEntryEdit.setOnClickListener {
                    val action = FragmentDrugListDirections.actionFragmentDrugListToFragmentDrug(FormScreenMode.EDITING).setDrugId(drugEntry.idOfDrug)
                    it.findNavController().navigate(action)
                }
            }

            nameOfDrug.text = drugEntry.nameOfDrug
            typeOfDrug.text = drugEntry.typeOfDrug
        }
    }
}