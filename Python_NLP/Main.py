import nltk
from nltk.corpus import stopwords
from nltk.stem import WordNetLemmatizer
from collections import Counter
import pandas as pd

if __name__ == '__main__':
    # nltk.download('wordnet') Only Once
    # nltk.download('stopwords')

    print("The paragraph:")
    paragraph = "The quick brown fox jumped over the lazy dog The dog barked and the fox ran away"
    print(paragraph)

    # Remove small words
    arr = ["a", "are", "the"]
    words = paragraph.split()
    filtered_words = [word.lower() for word in words if word.lower() not in arr]

    # Lemmatization
    lemmatizer = WordNetLemmatizer()
    lemmatized_words = [lemmatizer.lemmatize(word) for word in filtered_words]

    # Remove stopwords
    stop_words = set(stopwords.words('english'))
    filtered_lemmatized_words = [word for word in lemmatized_words if word not in stop_words]

    # Calculate word frequencies
    word_freq = Counter(filtered_lemmatized_words)

    print("Word frequencies:")
    print(word_freq)

    # Display words with similar meanings in a table
    print("\nWords with similar meanings:")
    for word, frequency in word_freq.items():
        synonyms = []  # You can use a suitable NLP library to get synonyms for a word
        synonyms_str = ', '.join(synonyms)
        print(f"{word}: {frequency}  Synonyms: {synonyms_str}")

    sorted_words_alpha = sorted(word_freq.keys())

    # Sort words based on frequency
    sorted_words_freq = sorted(word_freq.items(), key=lambda x: x[1], reverse=True)

    # Create a hash map (dictionary) for the frequencies
    freq_hash_map = dict(sorted_words_freq)

    # Present data in a table format
    table_data_alpha = {'Word (Alphabetical Order)': sorted_words_alpha}
    table_data_freq = {'Word (Frequency Order)': [word[0] for word in sorted_words_freq],
                       'Frequency': [word[1] for word in sorted_words_freq]}

    df_alpha = pd.DataFrame(table_data_alpha)
    df_freq = pd.DataFrame(table_data_freq)

    print("\nWords in Alphabetical Order:")
    print(df_alpha)

    print("\nWords in Frequency Order:")
    print(df_freq)
