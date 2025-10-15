import ItemForm from "../../components/itemForm/itemForm";
import ItemList from "../../components/itemList/ItemList";
import './ManageItems.css';


const ManageItems = () => {
    return (
        <div className="items-container text-light">
            <div className="left-column">
                <ItemForm/>
            </div>
            <div className="right-column">
                <ItemList/>
            </div>
        </div>
    )
}

export default ManageItems;