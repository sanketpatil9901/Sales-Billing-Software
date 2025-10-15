import { useContext, useEffect, useState } from "react";
import { assets } from "../../assets/assets";
import toast from "react-hot-toast";
import { addCategory } from "../../service/CategoryService";
import { AppContext } from "../../context/AppContext";

const CategoryForm = () => {
  const {setCategories, categories} = useContext(AppContext)
  const [loading, setLoading] = useState(false);
  const [image, setImage] = useState(false);
  const [data, setData] = useState({
    name:"",
    description:"",
    bgColor:"#2c2c2c"
  });

  useEffect(()=>{
    console.log(data);
  },[data])
  const onChangeHandler = (e) => {
    const value = e.target.value;
    const name = e.target.name;
    setData((data)=> ({...data, [name]:value}))
  }

  const submitHandler = async (e) => {
    e.preventDefault();
    if(!image) {
      toast.error("Select image for catgeory");
      return;
    }
    setLoading(true);
    const formdata = new FormData();
    formdata.append('category', JSON.stringify(data));
    formdata.append('file', image);
    try {
      const response = await addCategory(formdata);
      if(response.status === 201) {
        setCategories([...categories, response.data]);
        toast.success("Category added");
        setData({
          name:"",
          description:"",
          bgColor:"#2c2c2c"
        });
        setImage(false);
      }
    }  catch(error) {
      console.error(error);
    } finally {
      setLoading(false);
    }
  }
  return (
    <div className="mx-2 mt-2">
      <div className="row">
        <div className="card col-md-12 form-container">
          <div className="card-body">
            <form action="" onSubmit={submitHandler}>
              <div className="mb-3">
                <label htmlFor="image" className="form-lable">
                  <img src={image ? URL.createObjectURL(image) : assets.upload } alt="" width={48} />
                </label>
                <input
                  type="file"
                  name="image"
                  id="image"
                  className="form-control"
                  onChange={(e)=> setImage(e.target.files[0])}
                  hidden
                />
              </div>
              <div className="mb-3">
                <label htmlFor="name" className="form-label">
                  Name
                </label>
                <input
                  type="text"
                  name="name"
                  id="name"
                  className="form-control"
                  placeholder="Category Name"
                  onChange={onChangeHandler}
                  value={data.name}
                  required
                />
              </div>
              <div className="mb-3">
                <label htmlFor="description" className="form-label">
                  Description
                </label>
                <textarea
                  rows="5"
                  name="description"
                  id="description"
                  className="form-control"
                  placeholder="Write Content here"
                  onChange={onChangeHandler}
                  value={data.description}
                ></textarea>
              </div>
              <div className="mb-3">
                <label htmlFor="bgcolor" className="form-label">
                  Background color
                </label> <br />
                <input
                  type="color"
                  name="bgColor"
                  id="bgcolor"
                  placeholder="#ffffff"
                  onChange={onChangeHandler}
                  value={data.bgColor}
                  required
                />
              </div>
              <button type="submit"
               className="btn btn-warning w-100"
               disabled={loading}
               >
                {loading ? "Loading..." : "Submit"}
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CategoryForm;
