package com.example.eron.ui.tools;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        String head = "A Special Note on Assessment\n" +
                "Headache is a common childhood complaint and has many simple causes.  Yet it can also be an early warning signal of several very serious but less common conditions. If your child has any of the specific symptoms listed below, call your doctor immediately. Even if you have a family history of migraines and you suspect your child is having a migraine, you should leave this diagnosis to a physician so that more serious diagnoses are not missed.\n" +
                "\n" +
                "If the headache has any of the following characteristics, go to an emergency room:\n" +
                "It is the worst headache the child has ever had and it does not respond to treatment.\n" +
                "It is associated with any of the following:\n" +
                "a stiff neck\n" +
                "persistent vomiting\n" +
                "drowsiness or confusion\n" +
                "body weakness\n" +
                "unusual eye or limb movements\n" +
                "personality change\n" +
                "loss of previous skills such as walking\n" +
                "\n" +
                "A headache that has any of the following characteristics re- quires a prompt visit to the doctor:\n" +
                "It wakes the child from sleep or occurs early in the morning.\n" +
                "It lasts over twenty-four hours consistently, especially if worsening, or not responding to home treatment.\n" +
                "\n" +
                "TIP 196\n" +
                "\n" +
                "Meningitis is an infection of the membranes covering the brain. It is most common in infants, who usually do not show specific signs (see Tip 232 for additional important information on meningitis in infants). Bacterial meningitis is more serious than the viral type, and early diagnosis can dramatically reduce the chances of deafness, cognitive impairment, and death.\n" +
                "\n" +
                "If your child has the above symptoms, especially if they are accompanied by photophobia (sensitivity to light), he or she must be seen on an emergency basis by a doctor. In the early stages of meningitis, the child may not have a stiff neck.\n" +
                "\n" +
                "Early treatment with intravenous antibiotics has a high cure rate (see Tip 3 for additional information on meningitis).\n" +
                "\n" +
                "TIP 197\n" +
                "\n" +
                "Brain tumors are the most common type of childhood tumor. The early diagnosis of certain tumors can have a major impact on the child’s survival.\n" +
                "\n" +
                "If the cause of your child’s headache is a brain tumor, then the increasing pressure on the brain will cause headaches, usually in the morning, and these may be accompanied by vomit- ing and visual disturbances, most often double vision. Other symptoms may include unsteadiness during walking, slow growth in height, early puberty, seizures, or a personality change. Headaches can be caused by many non-serious conditions too, but it is important to have your child assessed and thoroughly evaluated as soon as possible.\n" +
                "\n" +
                "TIP 198\n" +
                "This condition, known as benign intracranial hypertension or pseudotumor cerebri, is most common in adolescent girls. Usually the cause is unknown, but it may occasionally be the result of factors such as a hormonal imbalance, a drug side effect (for example, it could be caused by tetracycline and/or other medicines used for adolescent skin conditions), high doses of vitamin A, or obesity. Frequently no specific origin can be found.\n" +
                "\n" +
                "The first step toward diagnosis is a brain scan, as this will help exclude other causes of increased pressure of the fluid around the brain, such as a tumor. If the scan is negative, a spinal tap can be used to detect when there is very high pressure of the fluid on the brain. This condition is important to diagnose because it may cause symptoms similar to a brain tumor but has a much better outcome. See your doctor as soon as possible for assessment and possible referral to a neurologist (brain specialist).\n" +
                "\n" +
                "TIP 199\n" +
                "\n" +
                "Sources such as a leaking gas furnace, pipe, or water heater may result in carbon monoxide poisoning. Using a charcoal grill, camp stove, or kerosene heater without proper ventilation, leaving a car running in an enclosed area, or inhaling fumes from a boat motor are other common causes of carbon monoxide poisoning.\n" +
                "\n" +
                "\n" +
                "Sometimes the sources are not immediately apparent. Inexpensive carbon monoxide monitors are sold in most hardware or department stores and will alert you to dangerous gas levels. Consider installing one on each level of your home or boat. Have your home heating system (including chimneys) checked and cleaned by a professional each year, and if you use any kind of boat with a motor, the engine and exhaust system should be checked regularly as well. If you develop any of the symptoms of carbon monoxide poisoning while in your car, get the exhaust system checked and make sure there are no holes in the floorboard.\n" +
                "\n" +
                "Though any children in the area will probably come down with symptoms first, carbon monoxide poisoning can kill both children and adults quickly. If several people in the household develop headaches simultaneously and/or become drowsy, everyone should leave the house immediately. Call the gas company, and get emergency medical attention.\n" +
                "\n" +
                "TIP 200\n" +
                "\n" +
                "After a significant injury to the head, slow bleeding may start inside the skull, and the child may gradually get drowsy due to the increasing pressure within his or her head. If your child injures his/her head and initially seems fine, observe him/her closely for at least the next two or three days. This includes waking the child every hour for the f\n";
        mText.setValue(head);
    }

    public LiveData<String> getText() {
        return mText;
    }
}