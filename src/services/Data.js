import axios from "axios";

export const getData = async () => {
  let response = await axios.get("http://localhost:8080/HRC_Backend/Fetch");
  console.log(response.data.invoiceData);

  let data = response.data.invoiceData;
  data.map((invoice, index) => ({ ...invoice, id: index }));
  return data;
};

export const GetSearchData = async (cust_number) => {
  console.log(cust_number);
  let searchResponse = await axios.get(
    "http://localhost:8080/HRC_Backend/Search" +
      "?" +
      "cust_number=" +
      cust_number
  );
  let searchData = searchResponse.data.searchObj;
  console.log(searchData);
  searchData.map((searchObj, index) => ({ ...searchObj, id: index }));
  return searchData;
};


export const GetAdvancedSearchData = async (
  doc_id,
  invoice_id,
  cust_number,
  buisness_year
) => {
  let advancedSearchResponse = await axios.get(
    "http://localhost:8080/HRC_Backend/AdvancedSearch" +
      "?" +
      "cust_number=" +
      cust_number +
      "&buisness_year=" +
      buisness_year +
      "&doc_id=" +
      doc_id +
      "&invoice_id=" +
      invoice_id
  );
  let advanceSearchData = advancedSearchResponse.data.advanceSearchObj;
  console.log(advanceSearchData);
  advanceSearchData.map((advanceSearchObj, index) => ({
    ...advanceSearchObj,
    id: index,
  }));
  return advanceSearchData;
};
